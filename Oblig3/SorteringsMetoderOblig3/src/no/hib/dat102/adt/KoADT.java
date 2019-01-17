package no.hib.dat102.adt;

public interface KoADT<T> {
	/**
	 * Legge inn et element bak i k�en
	 * @param element det som skal inn i k�en
	 */
	void innKoe(T element);
	/**
	 * Fjerner of returnerer elementet foran i k�en
	 * @return Elementet foran den som ble slettet
	 */
	T utKoe();
	/**
	 * Finner det f�rste elementet i k�en
	 * @return det f�rste elementet
	 */
	
	T foerste();
	/**
	 * Sjekker om k�en er tom
	 * @return boolean som er true om k�en er tom
	 */
	
	boolean erTom();
	
	/**
	 * Returnere antallet elementer i k�en
	 * @return int som av antallet
	 */
	int antall();
}
