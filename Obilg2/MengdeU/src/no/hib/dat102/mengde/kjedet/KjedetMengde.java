package no.hib.dat102.mengde.kjedet;

import no.hib.dat102.mengde.adt.*;
import no.hib.dat102.mengde.tabell.TabellMengde;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		// --- Oppgave ---
		if(!erTom()) {
			// Om du skal fjerne første node
			if(element.equals(start.getElement())) {
				resultat = start.getElement();
				start = start.getNeste();
				funnet = true;
			}
			else { //Om du skal fjerne noe annet enn første node
				forgjenger = start;
				for (int nr = 2; nr < antall && !funnet; nr++) {
					aktuell = forgjenger.getNeste();
					if(aktuell.getElement().equals(element)) {
						resultat = aktuell.getElement();
						forgjenger.setNeste(aktuell.getNeste());
						funnet = true;
					}
					forgjenger = forgjenger.getNeste();
				}
			}
			
		}
		if(funnet) {
			antall--;
		}
		return resultat;
	}//

	

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;
		/*
		 * Oppgave
		 */
		while(aktuell != null) {
			((KjedetMengde<T>) begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!inneholder(element)){
				((KjedetMengde<T>)begge).settInn(element);
			}
		}
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		/* Fyll ut...
		 * 
			if (this.inneholder(element))		 
				((KjedetMengde<T>) snittM).settInn(element);
		*/
		Iterator<T> iterator = m2.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(this.inneholder(element)) {
				((KjedetMengde<T>) snittM).settInn(element);
			}
		}
		return snittM;
	}

	

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		/*Fyll ut
		 * 
		 */
		Iterator<T> iterator = this.oppramser();
		while(iterator.hasNext()) {
			element = iterator.next();
			if(!m2.inneholder(element)) {
				((KjedetMengde<T>) differensM).settInn(element);
			}
		}
		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element = null;
		// --- Oppgave ---
		Iterator<T> iterator = m2.oppramser();
		if(antall == m2.antall()) {
			while(iterator.hasNext() && likeMengder) {
				if(!inneholder(iterator.next())) {
					likeMengder = false;
				}
			}
		}
		else {
			likeMengder = false;
		}
		return likeMengder;
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
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}
	
	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		//Fyll ut
		Iterator<T> iterator = m2.oppramser();
		if(this.antall < m2.antall()) {
			return false;
		}
		while(iterator.hasNext()) {
			T element = iterator.next();
			if(!this.inneholder(element)) {
				return false;
			}
		}
		return erUnderMengde;
	}
	
	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = start;
		
		boolean forste = true;
		while(aktuell != null) {
			resultat += (forste ? "" : ", ") + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
			forste = false;
		}
		return resultat;
	}

}// class
