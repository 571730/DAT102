package no.hib.dat102.tabell;

import no.hib.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		//... Fyll ut
		if(!erTom()) {
			resultat = liste[bak-1];
			liste[bak-1] = null;
			bak--;
		}
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		//... Fyll ut
		if(!erTom()) {
			resultat = liste[0];
			bak--;
			//Flytter alle elementer ett hakk nedover i listen
			for(int i = 0; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		return resultat;
	}

     @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		//...Fyll ut
		if(!erTom()) {
			resultat = liste[bak-1];
		}
		
	return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
		//...Fyll ut
    	//Sjekker om listen er full, og utvider om det trengs
    	if(bak == liste.length) {
    		utvid();
    	}
    	int i = 0;
    	//Finner hvor elementet skal
    	while(i < bak && element.compareTo(liste[i]) > 0) {
    		i++;
    	}
    	int j = bak;
    	while(j > i) {
    		liste[j] = liste[j-1];
    		j--;
    	}
    	liste[i] = element;
    	bak++;
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		// ...Fyll ut
		int index = finn(element);
		
		if(index != -1) {
			bak--;
			//Flytter alle elementer ett hakk nedover i listen
			for(int i = index; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		else {
			element = null;
		}
		return element;
		
	}		

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		//...Fyll ut
		if(erTom()) {
			return resultat;
		}
		while(resultat == -1 && i < bak) {
			if(liste[i].equals(el)) {
				resultat = i;
			}
			else {
				i++;
			}
		}
		if(resultat == -1) {
			System.out.println("Fannt ikke elementet");
		}
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}// class
