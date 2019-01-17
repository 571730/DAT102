package no.hib.dat102;


import no.hib.dat102.adt.OrdnetListeADT;
import no.hib.dat102.tabell.TabellOrdnetListe;

public class TabellOrdnetListeTest extends ListeADTTest{

	public OrdnetListeADT<Integer> reset() {
		return new TabellOrdnetListe<Integer>();
	}

}
