package no.hib.dat102.oppgave2;

import java.util.Scanner;

import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
	public static Medlem lesMedlem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv inn navn:");
		String navn = sc.nextLine();
		System.out.println("Skriv inn hobbyer skillt av mellomrom");
		String hobbyerString = sc.nextLine();
		
		String[] hobbyListe = hobbyerString.split(" ");
		KjedetMengde<Hobby> mengde = new KjedetMengde<>();
		
		for(String s : hobbyListe) {
			mengde.leggTil(new Hobby(s));
		}
		
		return new Medlem(navn, mengde);
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene!");
		System.out.println(medlem.getHobbyer().toString());
	}
	
	public static void skrivParListe (Datakontakt arkiv) {
		Medlem[] listen = arkiv.getMedlemstabell();
		int antallPar = 0;
		
		System.out.format("%-20s %s%n", "PARNAVN", "HOBBYER");
		for(int i = 0; i < arkiv.getAntallMedlemmer(); i++) {
			if(listen[i].getStatusIndex() != -1 && listen[i].getStatusIndex() > i) {
				int partnerIndex = listen[i].getStatusIndex();
				System.out.format("%-20s", listen[i].getNavn() + " og " + listen[partnerIndex].getNavn());
				System.out.format(" %s%n", "<" + listen[i].getHobbyer().toString() + ">");
				antallPar++;
			}
		}
		System.out.println("Antall par funnet: " + antallPar);
	}
}
