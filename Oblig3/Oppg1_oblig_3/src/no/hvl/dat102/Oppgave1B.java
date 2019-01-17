package no.hvl.dat102;

public class Oppgave1B {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println("Ledd " + i);
			System.out.println(folge(i));
		}
	}
	
	public static int folge(int ledd) {
		if(ledd == 0) {
			return 2;
		}
		else if(ledd == 1) {
			return 5;
		}
		else {
			return (5*(folge(ledd-1)) - (6*(folge(ledd-2))) + 2);
		}
	}
}
