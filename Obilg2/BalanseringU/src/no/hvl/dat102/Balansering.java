package no.hvl.dat102;

import java.io.*;

import no.hib.dat102.kjedet.KjedetStabel;

public class Balansering {
	// Her opphever du kommentarsetning n�r du har f�tt lagt inn
	// n�dvendig kode
	// SirkulaerStabel<Parentesinfo>stabel = new
	// SirkulaerStabel<Parentesinfo>();
	KjedetStabel<Parentesinfo> stabel = new KjedetStabel<>();

	private boolean passer(char �pent, char lukket) {
		switch (�pent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();
		// Fyll ut
		for(int i = 0; i < lengde; i++) {
			char c = innDataStreng.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				stabel.push(new Parentesinfo(linjenr, i, c));
			}
			if(c == ')' || c == ']' || c == '}') {
				//Om stabelen er tom
				if(stabel.erTom()) {
					System.out.println("Traff p� lukkesymbol " + c + " uten � finne �pnesymbol");
				}
				//Om de ikke matcher
				else{
					char venstre = stabel.pop().hentVenstreparentes();
					if(!passer(venstre, c)) {
						System.out.println("Fant lukkesymbol " + c + ", men det matchet ikke " + venstre);
					}
				}
			}
		}
		

	}//

	public void lesFraFil(String filnavn) {
		System.out.println("Begynner innlesning av fil");
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				// kalle metode her!
				// Fyll ut
				foretaBalansering(linje, linjenr);
				linje = tekstLeser.readLine();
			} // while
			//Stabelen er ikke tom etter � ha g�tt gjennom filen
			if(!stabel.erTom()) {
				System.out.println("Stabelen er ikke tom, s� det mangler lukketegn i filen");
				while(!stabel.erTom()) {
					System.out.println(stabel.pop().hentVenstreparentes() + " var igjen i stabelen");
				}
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
