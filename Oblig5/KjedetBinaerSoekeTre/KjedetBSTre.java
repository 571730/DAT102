import java.util.*;
//********************************************************************
// KjedetBinærSøkeTre.java        
//
//********************************************************************

class KjedetBinaerSokeTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt binært søketre.
	 ******************************************************************/
	public KjedetBinaerSokeTre() {
		antall = 0;
		rot = null;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public BinaerTreNode<T> getRot() {
		return rot;
	}

	public void setRot(BinaerTreNode<T> rot) {
		this.rot = rot;
	}

	/******************************************************************
	 * Oppretter et binært søketre med en node..
	 ******************************************************************/
	public KjedetBinaerSokeTre(T element) {
		antall = 1;
		rot = new BinaerTreNode<T>(element);
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære trett er tomt og usann ellers.
	 *****************************************************************/
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette binære treet er tom og usann ellers.
	 *****************************************************************/
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet på passende plass i BS-treet. Like
	 * elementer blir lagt til høyre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		// Den rekursive hjelpemetoden

		if (p == null) { // Tomt (under-)tre, lag node
			BinaerTreNode<T> ny = new BinaerTreNode<T>(element);
			return ny;
		} else if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));
			return p;
		} else {
			p.setHoyre(leggTilRek(p.getHoyre(), element)); // Ev. like til høgre
			return p;
		}
	}

	/******************************************************************
	 * Legger det spesifiserte elementet på passende plass i dette binære søketreet.
	 * Like elementer blir lagt til høyre.
	 ******************************************************************/

	public void leggTil2(T element) {
		BinaerTreNode<T> temp = new BinaerTreNode<T>(element);
		if (erTom())
			rot = temp;
		else {
			BinaerTreNode<T> aktuell = rot;
			boolean lagtTil = false;

			while (!lagtTil) {
				if (element.compareTo(aktuell.getElement()) < 0) {
					if (aktuell.getVenstre() == null) {
						aktuell.setVenstre(temp);
						lagtTil = true;
					} else
						aktuell = aktuell.getVenstre();
				} // if
				else { // >=
					if (aktuell.getHoyre() == null) {
						aktuell.setHoyre(temp);
						;
						lagtTil = true;
					} else
						aktuell = aktuell.getHoyre();
				} // else

			} // while
		}

		antall++;
	}

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 *********************************************************************/
	public T fjernMin() {
		T resultat = null;

		if (!erTom()) {
			if (rot.getVenstre() == null) {
				resultat = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getVenstre();
				while (aktuell.getVenstre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getVenstre();
				}
				resultat = aktuell.getElement();
				foreldre.setVenstre(aktuell.getHoyre());
			}

			antall--;
		}

		return resultat;
	}//

	/******************************************************************
	 * Fjerner noden med største verdi fra dette binære søketreet.
	 ******************************************************************/
	public T fjernMaks() {
		T resultat = null;

		if (!erTom()) {

			if (rot.getHoyre() == null) {
				resultat = rot.getElement();
				rot = rot.getVenstre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getHoyre();
				while (aktuell.getHoyre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getHoyre();
				}

				resultat = aktuell.getElement();
				foreldre.setHoyre(aktuell.getVenstre());
			}

			antall--;
		}

		return resultat;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMin() {

		T resultat = null;

		if (!erTom()) {
			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getVenstre() != null)
				aktuell = aktuell.getVenstre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}//

	/******************************************************************
	 * Returnerer det største elementet i dette binære søketreet.
	 ******************************************************************/
	public T finnMaks() {
		T resultat = null;

		if (!erTom()) {

			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getHoyre() != null)
				aktuell = aktuell.getHoyre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null elles. Bruk av rekursjon /
	 ******************************************************************************/
	public T finn(T element) {
		// Søk med rekursiv hjelpemetode

		return finnRek(element, rot);
	}

	// Den rekursive hjelpemetoden for søking
	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null;
		if (p != null) {
			if (element.compareTo(p.getElement()) == 0) { // I rot
				svar = p.getElement();
			} else if (element.compareTo(p.getElement()) < 0) {
				svar = finnRek(element, p.getVenstre()); // I venstre u.t.
			} else {
				svar = finnRek(element, p.getHoyre()); // I høgre u.t.
			}
		}
		return svar;
	}

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// Søk med while-setning

		BinaerTreNode<T> p = rot;
		T svar = null;
		while (p != null && svar == null) {
			if (element.compareTo(p.getElement()) < 0)
				p = p.getVenstre();
			else if (element.compareTo(p.getElement()) > 0)
				p = p.getHoyre();
			else
				svar = p.getElement();
		}
		return svar;
	}

	/******************************************************************
	 * Returnerer en inordeniterator for elementene i bs-treet.
	 ******************************************************************/
	public Iterator<T> iterator() {
		return new InordenIterator(rot);
	}

	// *****************************************************************
	// Gjennomgår treet i preorden
	// *****************************************************************

	public void visPreorden() {
		visRekPreorden(rot);
		System.out.println();
	}

	private void visRekPreorden(BinaerTreNode<T> p) {
		if (p != null) {
			System.out.print(p.getElement() + " ");
			visRekPreorden(p.getVenstre());
			visRekPreorden(p.getHoyre());
		}
	}

	// *****************************************************************
	// Gjennomgår treet i inorden
	// *****************************************************************

	public void visInorden() {
		visRekInorden(rot);
		System.out.println();
	}

	private void visRekInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visRekInorden(p.getVenstre());
			System.out.print(p.getElement() + " ");
			visRekInorden(p.getHoyre());
		}
	}
	public int hoyde() {
		return hentHoyde(rot);
	}
	
	public int hentHoyde(BinaerTreNode<T> node) {
		if (node == null) {
			return -1;
		} else {
			int vDybde = hentHoyde(node.getVenstre());
			int hDybde = hentHoyde(node.getHoyre());

			if (vDybde > hDybde)
				return (vDybde + 1);
			else
				return (hDybde + 1);
		}
	}

}// class

// ************************************************************************
