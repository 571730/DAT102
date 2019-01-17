package no.hvl.dat102.klient;

import java.util.Random;

import no.hvl.dat102.BobleSortering;
import no.hvl.dat102.FletteSortering;
import no.hvl.dat102.InnsettingSortering;
import no.hvl.dat102.QuickSortDAT102;
import no.hvl.dat102.QuickSortNy;
import no.hvl.dat102.QuickSortNyDAT102;
import no.hvl.dat102.QuickSortering;
import no.hvl.dat102.RadixSortering;
import no.hvl.dat102.Sortering;
import no.hvl.dat102.UtvalgSortering;

public class KlientSortering {
	
	public static void main(String[] args) {
		
		for (int i = 7; i < 10; i++) {
			taTiden(i);
		} 
		
	}
	
	public static void visListe(Integer[] liste) {
		for(Integer i : liste) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static Integer[] lagListe(int n) {
		Integer[] liste = new Integer[n];
		Random rdn = new Random();
		for(int i = 0; i < n; i++) {
			Integer tall = new Integer(rdn.nextInt(20));
			liste[i] = tall;
		}
		return liste;
	}
	
	public static void taTiden(int valg) {
		Sortering metode;
		String sMetode = "Ukjent";
		
		switch(valg) {
		case 1: metode = new InnsettingSortering();
		sMetode = "Innsettingsmetoden";
		break;
		case 2: metode = new UtvalgSortering();
		sMetode = "Utvalgsmetoden";
		break;
		case 3: metode = new BobleSortering();
		sMetode = "Boblesortering";
		break;
		case 4: metode = new QuickSortering();
		sMetode = "Quicksortering";
		break;
		case 5: metode = new FletteSortering();
		sMetode = "Flettesortering";
		break;
		case 6: metode = new RadixSortering();
		sMetode = "Radixsortering";
		break;
		case 7: metode = new QuickSortNy();
		sMetode = "Hybrid Quicksort";
		break;
		case 8: metode = new QuickSortDAT102();
		sMetode = "Quicksort som i forelesning:";
		break;
		case 9: metode = new QuickSortNyDAT102();
		sMetode = "Hybrid Quicksort som i forelesning:";
		break;
		default: metode = new InnsettingSortering();
		System.out.println("Feil ved valg, bruker innsetting");
		break;
		}
		
		for(int i = 32000; i <= 128000; i = i * 2) { //Lokke for n-verdier i listene 32k, 64k, 128k
			double snittTid = 0;
			System.out.println(sMetode + " med " + i + " elementer i listen.");
			for(int n = 0; n < 5; n++) { //Lokke for de 5 rundene som kjores
				Integer[] liste = lagListe(i); //Ny liste med verdier hver runde
				long start = System.nanoTime();
				metode.sorter(liste);
				long stop = System.nanoTime();
				double tid = (double) ((stop-start)/1000000);
				snittTid += tid;
			}
			snittTid = snittTid/5;
			System.out.println("Snitttid over 5 iterasjoner " + snittTid + "ms for " + i + " verdier");
			System.out.println("Sorteringsmetode: " + sMetode + "\n");
		}
		
		
	}

}
