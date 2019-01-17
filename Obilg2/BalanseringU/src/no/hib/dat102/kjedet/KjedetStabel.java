package no.hib.dat102.kjedet;

import no.hib.dat102.adt.StabelADT;
import no.hib.dat102.exception.EmptyCollectionException;

public class KjedetStabel<T> implements StabelADT<T> {
	private LinearNode<T> topp;
	private int antall;

	public KjedetStabel() {
		topp = null;
		antall = 0;
	}

	@Override
	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(topp);
		topp = nynode;
		antall++;
	}

	@Override
	public T pop() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("stabel");

		T resultat = topp.getElement();
		topp = topp.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T peek() throws EmptyCollectionException {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		
		return topp.getElement();
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

}