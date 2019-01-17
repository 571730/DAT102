package no.hib.dat102.mengde.adt;

import java.util.Iterator;

public interface MengdeADT<T> {
	// Interface som definerer alle operasjoner i en ADT
	// med navn MengdeADT (en datasamling, en høynivå datastruktur)

	/**
	 * Legger til et objekt av klasse T til dette mengde-objektet hvis det ikke
	 * fins fra før
	 * 
	 * @param element som skal legges til
	 */
	void leggTil(T element);
	
	/**
	 * 
	 * @param m2 er mengden som skal legges til denne mengden
	 */
	void leggTilAlle(MengdeADT<T> m2);

	/**
	 * Fjerner og returnerer et tilfeldig element fra mengden
	 * 
	 * @return returnerer det tilfeldige elementet ellers returneres null
	 */
	T fjernTilfeldig();

	/**
	 * 
	 * @param element er elemenentet som skal fjernes hvis det fins ellers returneres null
	 * @return elementet som fjernes
	 */
	T fjern(T element);

	/**
	 
	 * @param m2 er mengden det skal lages union med.
	 * @return er union av mengden m2 og this-mengden
	 */
	MengdeADT<T> union(MengdeADT<T> m2);

	/**
	 * 
	 * @param element er det gitte elementet
	 * @return sann hvis elementet fins ellers usann
	 */
	boolean inneholder(T element);

	/**
	 * Tester om this-mengden og parameteren inneholder nøyaktig de samme
	 * elementene
	 * 
	 * @param m2 er  mengden som testes
	 * @return sann hvis de to mengden er like ellers usann
	 */
	boolean equals(MengdeADT<T> m2);

	/**
	 * Tester om mengden er tom (dvs. har 0 element)
	 * 
	 * @return sann hvis mendgen er tom ellers usann
	 */
	boolean erTom();

	/**
	 * Finn antall elementer i mengden
	 * 
	 * @return antall i mengden
	 */
	int antall();

	/**
	 * 
	 * @param m2
	 * @return
	 */
	MengdeADT<T> snitt(MengdeADT<T> m2);
	/**
	 * 
	 * @param m2
	 * @return
	 */

	MengdeADT<T> differens(MengdeADT<T> m2);
	
	
	/**
	 * 
	 * @param m2 er parametermengden
	 * @return true hvis m2 er en undermengde av denne mengden, ellers false
	 */
	public boolean undermengde(MengdeADT<T> m2);

	/**
	 * Oppretter et 'oppramsobjekt' som kan brukes til å gjennomgå alle
	 * elementer i mengden etter tur en gang
	 * 
	 * @return et oppramsobjekt
	 */
	
	
	Iterator<T> oppramser();

	

}// ADT
