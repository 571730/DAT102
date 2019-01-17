package no.hib.dat102;

import no.hib.dat102.adt.OrdnetListeADT;
import no.hib.dat102.kjedet.KjedetOrdnetListe;

public class KjedetOrdnetListeTest extends ListeADTTest{

	public OrdnetListeADT<Integer> reset() {
		return new KjedetOrdnetListe<Integer>();
	}

}
