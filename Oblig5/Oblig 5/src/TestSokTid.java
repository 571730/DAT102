import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class TestSokTid {
	public static void main(String[] args) {
		int antElement = 100000;
		int omraade = 999999;
		ArrayList<Integer> liste = new ArrayList<Integer>(antElement);
		HashSet<Integer> hSet = new HashSet<Integer>(antElement);
		Random random = new Random();

		int tall = 376; // Her kan vi bruke eit vilkårleg tal
		for (int i = 0; i < antElement; i++) {
			// legg tall til i HashSet og tabell
			tall = (tall + 45713) % 1000000; // Sjå nedanfor om 45713
			liste.add(tall);
			hSet.add(tall);
		}

		Collections.sort(liste);

		ArrayList<Integer> sokListe = new ArrayList<Integer>(10000);
		for (int i = 0; i < 10000; i++) {
			int num = random.nextInt(omraade);
			sokListe.add(num);
		}

		System.out.println("Søker i hashSet..");
		int funnetHash = 0;
		long timeStart = System.nanoTime();

		for (Integer i : sokListe) {
			if (hSet.contains(i)) {
				funnetHash++;
			}
		}
		long timeStop = System.nanoTime();

		System.out.println(
				"Det tok " + (((double) timeStop - timeStart) / 1000000) + "ms, den fant " + funnetHash + " tall");

		System.out.println("\nSøker med binærsøk..");
		int funnetList = 0;

		timeStart = System.nanoTime();

		for (Integer i : sokListe) {
			int funnet = Collections.binarySearch(liste, i);
			if (funnet >= 0) {
				funnetList++;
			}
		}
		timeStop = System.nanoTime();

		System.out.println(
				"Det tok " + (((double) timeStop - timeStart) / 1000000) + "ms, den fant " + funnetList + " tall");

	}

}
