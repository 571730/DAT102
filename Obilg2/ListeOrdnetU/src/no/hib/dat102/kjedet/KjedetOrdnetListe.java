package no.hib.dat102.kjedet;
import no.hib.dat102.adt.*;
/**
 * 
 * @param <T>
 *            elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;
		//...Fyll ut
		if(!erTom()) {
			svar = foerste.getElement();
			foerste = foerste.getNeste();
			antall--;
		}
		if(erTom()) {
			siste = null;
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		//...Fyll ut
		if(!erTom()) {
			svar = siste.getElement();
			antall--;
			if(antall == 0) {
				foerste = null;
				siste = null;
			}else {
				siste = foerste;
				for(int i = 1; i < antall; i++) {
					siste = siste.getNeste();
				}
				siste.setNeste(null);
			}
		}
		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		//...Fyll ut
		LinearNode<T> aktuell = foerste;
		LinearNode<T> forige = null;
		LinearNode<T> nyNode = new LinearNode<T>(element);
		boolean lagtTil = false;
		
		//Om kjeden er helt tom fra før
		if(foerste == null) {
			foerste = nyNode;
			siste = nyNode;
			antall++;
			lagtTil = true;
		}
		
		while(aktuell != null && !lagtTil) {
			//Om den nye noden skal inn på første plass i kjeden
			if(element.compareTo(foerste.getElement()) <= 0) {
				foerste = nyNode;
				nyNode.setNeste(aktuell);
				antall++;
				lagtTil = true;
			}
			//Om den nye noden skal legges til i slutten av kjeden
			else if(element.compareTo(siste.getElement()) > 0) {
				siste.setNeste(nyNode);
				siste = nyNode;
				antall++;
				lagtTil = true;
			}
			//Om den nye noden skal inn på noe annet enn første plass
			else if(element.compareTo(aktuell.getElement()) <= 0) {
				forige.setNeste(nyNode);
				nyNode.setNeste(aktuell);
				antall++;
				lagtTil = true;
			}
			forige = aktuell;
			aktuell = aktuell.getNeste();
		}
	}


	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
