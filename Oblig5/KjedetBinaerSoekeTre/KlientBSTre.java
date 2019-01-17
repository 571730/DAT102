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
			System.out.println("Maksimal teoretiske høyde blir " + (bs.getAntall() - 1));
			System.out.println("Minimal teoretisk høyde blir " + (Math.log(ANTALL_NODER)/Math.log(2)));
			
		}
		System.out.println("\nStørste hoyde i løpet av kjøringen var " + storsteTre);
		System.out.println("Minste høyde i løpet av kjøringen var " + minsteTre);
		snitt = snitt/ANTALL_TRE;
		System.out.println("Gjennomsnittshøyde for hele kjøringen var " + snitt);
		System.out.println("Treet inneholder verdier fra 0 til " + RANDOM_INTERVALL);
		
		KjedetBinaerSokeTre<Integer> as = new KjedetBinaerSokeTre<Integer>();
		System.out.println("Test tre skal nå ha høyde -1, kalkulert høyde er " + as.hoyde());
		as.leggTil(1);
		System.out.println("Test tre skal nå ha høyde 0, kalkulert høyde er " + as.hoyde());

	}
}// class