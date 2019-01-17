package no.hvl.dat102;

public class InnsettingSortering implements Sortering{
	private Integer[] sortert;
	private Integer[] usortert;
	
	public Integer[] getSortert() {
		return sortert;
	}
	
	public void sorter(Integer[] liste) {
		sortert = liste;
		Integer tall;
		
		for(int i = 1; i < sortert.length; i++) {
			tall = sortert[i];
			int j = i - 1;
			
			while(j >= 0 && sortert[j] > tall) {
				sortert[j + 1] = sortert[j];
				j--;
			}
			sortert[j+1] = tall;
		}
	}
}
