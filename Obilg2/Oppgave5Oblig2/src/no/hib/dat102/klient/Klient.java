package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.Person;
import no.hib.dat102.SirkulaerKoe;
import no.hib.dat102.kjedet.KjedetOrdnetListe;
import no.hib.dat102.tabell.*;

public class Klient {
	public static void main(String[] args) {
		
		SirkulaerKoe<Person> sirKoe = new SirkulaerKoe<>();
		TabellOrdnetListe<Person> tabOrdListe = new TabellOrdnetListe<>();
		KjedetOrdnetListe<Person> kjedetOrdListe = new KjedetOrdnetListe<>();
		
		
		for(int i = 0; i < 4; i++) {
			Person p = lagPerson();
			sirKoe.innKoe(p);
			tabOrdListe.leggTil(p);
			kjedetOrdListe.leggTil(p);
		}
		//Tester sirkulær kø
		System.out.println("\nKjøring av sirkulær kø\n");
	
		while(sirKoe.antall() != 0) {
			System.out.println("Tar person ut av køen");
			System.out.println(sirKoe.utKoe());
		}
		
		//Tester orndet liste
		System.out.println("\nKjøring av ordnet liste i stigende alder\n");
		int antall = tabOrdListe.antall();
		for(int i = 0; i < antall; i++) {
			System.out.println("Tar person ut av listen");
			System.out.println(tabOrdListe.fjernSiste());
		}
		
		//Tester kjedet ordnet liste
		System.out.println("\nKjøring av kjedet ordnet liste i stigende alder\n");
		int antallKjede = kjedetOrdListe.antall();
		for(int i = 0; i < antallKjede; i++) {
			System.out.println("Tar person ut av listen");
			System.out.println(kjedetOrdListe.fjernSiste());
		}
		
		
	}
	
	public static Person lagPerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv inn fødselsdato:");
		int fDato = sc.nextInt();
		sc.nextLine();
		System.out.println("Skriv inn etternavn:");
		String etternavn = sc.nextLine();
		System.out.println("Skriv inn fornavn:");
		String fornavn = sc.nextLine();
		return new Person(fornavn, etternavn, fDato);
	}
}
