package no.hib.dat102.oppgave2;

import java.util.Scanner;

public class Meny {
	public static void Meny(Datakontakt arkiv) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("---   HOVEDMENY   ---\t");
			System.out.println("1) Legg til ett medlemm");
			System.out.println("2) Skriv ut hobbyliste til et medlem");
			System.out.println("3) Skriv ut alle par");
			System.out.println("4) Finn partner til en person");
			System.out.println("5) Nullstill partner til en person");
			System.out.println("9) Avslutt programmet");
			int valg = sc.nextInt();
			sc.nextLine();
			
			if(valg == 1) {
				Medlem medlem = Tekstgrensesnitt.lesMedlem();
				arkiv.leggTilMedlem(medlem);
			}
			else if(valg == 2) {
				System.out.println("Hva heter medlemmet?");
				String navn = sc.nextLine();
				int pos = arkiv.finnMedlemsIndex(navn);
				Medlem[] liste = arkiv.getMedlemstabell();
				Tekstgrensesnitt.skrivHobbyListe(liste[pos]);
			}
			else if(valg == 3) {
				Tekstgrensesnitt.skrivParListe(arkiv);
			}
			else if(valg == 4) {
				System.out.println("Hva heter personen du vil matche?");
				String navn = sc.nextLine();
				int pos = arkiv.finnPartnerFor(navn);
				if(pos == -1) {
					System.out.println(navn + " matchet ikke med noen");
				}
				else {
					Medlem[] liste = arkiv.getMedlemstabell();
					System.out.println(navn + " matchet med " + liste[pos].getNavn());
				}
			}
			else if(valg == 5) {
				System.out.println("Hvem vil du nullstille?");
				String navn = sc.nextLine();
				arkiv.tilbakestillStausIndeks(navn);
			}
			else if(valg == 9) {
				run = false;
				System.out.println("Avslutter programmet");
			}
		}
	}
	
	public static void main(String[] args) {
		Datakontakt arkiv = new Datakontakt();
		Meny(arkiv);
	}
}
