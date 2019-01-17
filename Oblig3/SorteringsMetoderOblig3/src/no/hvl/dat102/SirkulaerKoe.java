package no.hvl.dat102;

import no.hib.dat102.adt.KoADT;

public class SirkulaerKoe<T> implements KoADT<T> {
	private static final int STDK = 100;
	private int front, bak, antall;
	private T[] koe;
	 
	public SirkulaerKoe() {
		this(STDK);
	}
	
	public SirkulaerKoe(int startKapasitet) {
		koe = (T[])(new Object[startKapasitet]);
		front= bak = 0;
		antall = 0;
	}
	@Override
	public void innKoe(T element) {
		if(antall == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak+1) % koe.length;
		antall++;
		
	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		T resultat = null;
		if(erTom()) {
			throw new EmptyCollectionException("Tom koe");
		}
		resultat = koe[front];
		koe[front] = null;
		front = (front+1) % koe.length;
		antall--;
		return resultat;
	}
	
	private void utvid() {
		T[] hjelpetabell = (T[])(new Object[koe.length * 2]);
		for(int soek = 0; soek<antall; soek++) {
			hjelpetabell[soek] = koe[front];
			front = (front+1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		return koe[front];
	}

	@Override
	public boolean erTom() {
		return antall==0;
	}

	@Override
	public int antall() {
		return antall;
	}

}
