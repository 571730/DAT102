package no.hib.dat102.adt;

public interface KoADT<T> {
	/**
	 * Legge inn et element bak i køen
	 * @param element det som skal inn i køen
	 */
	void innKoe(T element);
	/**
	 * Fjerner of returnerer elementet foran i køen
	 * @return Elementet foran den som ble slettet
	 */
	T utKoe();
	/**
	 * Finner det første elementet i køen
	 * @return det første elementet
	 */
	
	T foerste();
	/**
	 * Sjekker om køen er tom
	 * @return boolean som er true om køen er tom
	 */
	
	boolean erTom();
	
	/**
	 * Returnere antallet elementer i køen
	 * @return int som av antallet
	 */
	int antall();
}
