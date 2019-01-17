package no.hib.dat102.oppgave2;

import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusIndex;
	
	public Medlem(String navn, KjedetMengde<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		statusIndex = -1;
	}
	
	public Medlem() {
		this("Ukjent", new KjedetMengde<Hobby>());
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}
	
	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}
	
	public int getStatusIndex() {
		return statusIndex;
	}
	
	public void setStatusIndex(int statusIndex) {
		this.statusIndex = statusIndex;
	}
	
	public boolean passerTil(Medlem medlem2) {
		return statusIndex == -1 ? hobbyer.equals(medlem2.getHobbyer()): false; 
	}
}
