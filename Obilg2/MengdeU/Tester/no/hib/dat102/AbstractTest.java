package no.hib.dat102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.mengde.adt.MengdeADT;

public abstract class AbstractTest {
	private MengdeADT<Integer> intListe1;
	private MengdeADT<Integer> intListe2;
	private MengdeADT<Integer> svar;
	private MengdeADT<Integer> fasit;
	
	
	abstract MengdeADT<Integer> reset();
	
	@Before
	public void setup() {
		intListe1 = reset();
		intListe2 = reset();
		svar = reset();
		fasit = reset();
		
		for(int i = 1; i < 6; i++) {
			intListe1.leggTil(i*2);
			intListe2.leggTil((int)Math.pow(i, 2));
		}
	}
	
	@Test
	public void testUnion() {
		
		svar = intListe1.union(intListe2);
		
		for(int i = 1; i < 6; i++) {
			fasit.leggTil(i*2);
			fasit.leggTil((int)Math.pow(i, 2));
		}
		
		assertTrue(svar.equals(fasit));
		svar.fjernTilfeldig();
		assertFalse(svar.equals(fasit));
	}
	
	@Test
	public void testSnitt() {
		svar = intListe1.snitt(intListe2);
		fasit.leggTil(4);
		
		assertTrue(svar.equals(fasit));
		svar.fjernTilfeldig();
		assertFalse(svar.equals(fasit));
	}
	
	@Test
	public void testDifferens() {
		svar = intListe1.differens(intListe2);
		fasit.leggTil(2);
		fasit.leggTil(6);
		fasit.leggTil(8);
		fasit.leggTil(10);
		
		assertTrue(svar.equals(fasit));
		svar.leggTil(101);
		assertFalse(svar.equals(fasit));
	}
	
	@Test
	public void testUndermengde() {	
		
		for(int i = 1; i < 6; i++) {
			intListe2.leggTil(i*2);
			intListe2.leggTil((int)Math.pow(i, 2));
		}
		
		assertTrue(intListe2.undermengde(intListe1));
		
		intListe1.leggTil(100);
		
		assertFalse(intListe2.undermengde(intListe1));
	}
	
}
