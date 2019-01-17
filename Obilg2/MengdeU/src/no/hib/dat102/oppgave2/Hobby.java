package no.hib.dat102.oppgave2;

public class Hobby {
	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	public String toString() {
		return hobbyNavn;
	}
	
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}
