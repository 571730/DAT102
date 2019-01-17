package no.hib.dat102.tabell;
import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.exception.EmptyCollectionException;

//  Tabellimplementasjon av en stabel.
//********************************************************************

public class TabellStabel<T> implements StabelADT<T> {
	private final static int STDK = 100;
	private int topp; // indikerer neste plass
	private T[] stabel;

	/*******************************************************************
	 * Oppretter en tom stabel.
	 *******************************************************************/
	
	public TabellStabel() {
		this(STDK);		
	}

	/*******************************************************************
	 * Oppretter en tom stabel med en speisfisert kapasitet.
	 *******************************************************************/
	public TabellStabel(int startKapasitet) {
		topp = 0;
		stabel = (T[]) (new Object[startKapasitet]);
	}

	/*******************************************************************
	 * Legger til det spesifiserte elementet p� toppen av stabelen, utvider
	 * kapasitetet til stabelen hvis n�dvendig.
	 *******************************************************************/
	@Override
	public void push(T element) {
		if (antall() == stabel.length)
			utvid();

		stabel[topp] = element;
		topp++;
	}

	/*******************************************************************
	 * 
	 * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen
	 * er tom fra f�r, s� returneres null
	 *******************************************************************/
	@Override
	public T pop() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		topp--;
		T result = stabel[topp];
		stabel[topp] = null;

		return result;
	}

	/*******************************************************************
	 * Returnerer toppelementet uten � fjerne det. Hvis stabelen er tom fra
	 * f�r, s� returneres null
	 *******************************************************************/
	@Override
	public T peek() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		return stabel[topp - 1];
	}

	/*******************************************************************
	 * Returnerer sann hvis stabelen er tom og usann ellers.
	 *******************************************************************/
	@Override
	public boolean erTom() {
		return (topp == 0);
	}

	/*******************************************************************
	 * Returnerer antall elementer.
	 *******************************************************************/
	@Override
	public int antall() {
		return topp;
	}

	
	/*******************************************************************
	 * Oppretter en ny tabell for � lagre innholdet.
	 *******************************************************************/
	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

		for (int indeks = 0; indeks < stabel.length; indeks++)
			hjelpeTabell[indeks] = stabel[indeks];

		stabel = hjelpeTabell;
	}
}
