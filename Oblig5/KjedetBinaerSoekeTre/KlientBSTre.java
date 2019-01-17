import java.util.*;

class KlientBSTre {
	public static void main(String[] a) {
		
		final int ANTALL_NODER = 4096;
		final int ANTALL_TRE = 100;
		final int RANDOM_INTERVALL = 5000;
		
		Random tilfeldig = new Random();
		int storsteTre = 0;
		int minsteTre = 2000;
		int snitt = 0;
		for(int i = 0; i < ANTALL_TRE; i++) {
			KjedetBinaerSokeTre<Integer> bs = new KjedetBinaerSokeTre<Integer>();
			for (int n = 0; n < ANTALL_NODER; n++) {
				Integer element = new Integer(tilfeldig.nextInt(RANDOM_INTERVALL));
				bs.leggTil(element);
			}
			int hoyde = bs.hoyde();
			snitt += hoyde;
			if(hoyde > storsteTre) {
				storsteTre = hoyde;
			}
			if(hoyde < minsteTre) {
				minsteTre = hoyde;
			}
			System.out.println("Dette treet har " + bs.getAntall() + " noder");
			System.out.println("Maksimal teoretiske h�yde blir " + (bs.getAntall() - 1));
			System.out.println("Minimal teoretisk h�yde blir " + (Math.log(ANTALL_NODER)/Math.log(2)));
			
		}
		System.out.println("\nSt�rste hoyde i l�pet av kj�ringen var " + storsteTre);
		System.out.println("Minste h�yde i l�pet av kj�ringen var " + minsteTre);
		snitt = snitt/ANTALL_TRE;
		System.out.println("Gjennomsnittsh�yde for hele kj�ringen var " + snitt);
		System.out.println("Treet inneholder verdier fra 0 til " + RANDOM_INTERVALL);
		
		KjedetBinaerSokeTre<Integer> as = new KjedetBinaerSokeTre<Integer>();
		System.out.println("Test tre skal n� ha h�yde -1, kalkulert h�yde er " + as.hoyde());
		as.leggTil(1);
		System.out.println("Test tre skal n� ha h�yde 0, kalkulert h�yde er " + as.hoyde());

	}
}// class