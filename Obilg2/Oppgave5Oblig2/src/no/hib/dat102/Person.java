package no.hib.dat102;

public class Person implements Comparable<Person>{
	private String fornavn;
	private String etternavn;
	private int fodtaar;
	
	public Person(String fornavn, String etternavn, int fodtaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodtaar = fodtaar;
	}
	
	public Person() {
		this("Ukjent", "Ukjent", 0000);
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodtaar() {
		return fodtaar;
	}

	public void setFodtaar(int fodtaar) {
		this.fodtaar = fodtaar;
	}

	@Override
	public String toString() {
		return fodtaar + " " + etternavn + ", " + fornavn;
	}
	
	public int compareTo(Person denAndre) {
		if(fodtaar < denAndre.getFodtaar()) {
			return -1;
		}
		else if(fodtaar > denAndre.getFodtaar()) {
			return 1;
		}
		else if(etternavn.compareTo(denAndre.getEtternavn()) != 0) {
			return etternavn.compareTo(denAndre.getEtternavn());
		}
		else if(fornavn.compareTo(denAndre.getFornavn()) != 0) {
			return fornavn.compareTo(denAndre.getFornavn());
		}
		else {
			return 0;
		}
	}
	
	
}
