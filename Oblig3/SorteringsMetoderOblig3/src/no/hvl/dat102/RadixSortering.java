package no.hvl.dat102;

public class RadixSortering implements Sortering {
	private Integer[] sortert;
	
	public void sorter(Integer[] liste) {
		sortert = liste;
		sort(liste);
	}
	
	public void sort(Integer[] arr) {
		String temp;
		Integer tallObj;
		int siffer, tall;
		SirkulaerKoe<Integer>[] sifferKoer = (SirkulaerKoe<Integer>[]) (new SirkulaerKoe[10]);
		// Sirkulærkoe er mer effektiv ved uttak
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoer[sifferVerdi] = new SirkulaerKoe<Integer>();
		}

		/** sorterer liste */
		for (int posisjon = 0; posisjon <= 1; posisjon++) {// ytre løkke
			for (int i = 0; i < arr.length; i++) {// indre løkke
				temp = String.valueOf(arr[i]);
				if(temp.length()<2) {
					temp = "0" + temp;
				}
				siffer = Character.digit(temp.charAt(1-posisjon), 10);
				sifferKoer[siffer].innKoe(new Integer(arr[i]));
			} // indre løkke
			/* legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoer[sifferVerdi].erTom())) {
					tallObj = sifferKoer[sifferVerdi].utKoe();
					arr[tall] = tallObj.intValue();
					tall++;
				} // while
			} // for
		} // ytre løkke
	}
	
	public int getDigit(Integer tall, int pos) {
		int tallet = tall.intValue();
		for(int i = 0; i < pos; i++) {
			tallet /= 10;
		}
		return tallet % 10;
		
	}

}
