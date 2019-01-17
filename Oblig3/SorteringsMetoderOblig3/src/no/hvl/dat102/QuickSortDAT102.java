package no.hvl.dat102;

public class QuickSortDAT102 implements Sortering {
	private Integer[] sortert;

	@Override
	public void sorter(Integer[] liste) {
		sortert = liste;
		kvikkSort(0, liste.length-1);
	}

	public void kvikkSort(int min, int maks) {
		int posPartisjon;
		if (min < maks) { // minst to element
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
