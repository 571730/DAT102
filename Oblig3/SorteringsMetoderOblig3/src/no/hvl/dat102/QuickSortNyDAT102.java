package no.hvl.dat102;

public class QuickSortNyDAT102 implements Sortering {
	private static final int MIN = 8000;
	private Integer[] sortert;


	public void sorter(Integer[] liste) {
		sortert = liste;
		sort();
	}

	public void sort() {
		kvikkSort(0, sortert.length - 1);
		sorteringVedInnsetting2(0, sortert.length-1);
	}

	public void sorteringVedInnsetting2(int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {

			Integer nokkel = sortert[indeks];
			int p = indeks;
			// Forskyv større verdier mot høyre
			while (p > 0 && sortert[p - 1].compareTo(nokkel) > 0) {
				sortert[p] = sortert[p - 1];
				p--;
			}
			sortert[p] = nokkel;
		} // ytre
	}
	
	public void kvikkSort(int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > MIN) { // minst to element
			/** Lager partisjon */
			posPartisjon = finnPartisjon(min, maks);
			/** Sorterer venstre side */
			kvikkSort(min, posPartisjon-1);
			/** Sorterer høyre side */
			kvikkSort(posPartisjon + 1, maks);
		}
	}
	
	public int finnPartisjon(int min, int maks) {
		int venstre, hoyre;
		Integer temp, pivot;
		pivot = sortert[min];
		venstre = min;
		hoyre = maks;
		while(venstre < hoyre) {
			while(venstre < hoyre && sortert[venstre].compareTo(pivot)<=0) {
				venstre++;
			}
			while(sortert[hoyre].compareTo(pivot)>0) {
				hoyre--;
			}
			if(venstre < hoyre) {
				temp = sortert[venstre];
				sortert[venstre] = sortert[hoyre];
				sortert[hoyre] = temp;
			}
		}
		temp = sortert[min];
		sortert[min] = sortert[hoyre];
		sortert[hoyre] = temp;
		return hoyre;
	}

}
