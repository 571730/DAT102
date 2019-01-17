package no.hvl.dat102;

public class BobleSortering implements Sortering{
	private Integer[] sortert;
	
	public void sorter(Integer[] liste) {
		sortert = liste;
		 int n = sortert.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (sortert[j] > sortert[j+1])
	                {
	                    int temp = sortert[j];
	                    sortert[j] = sortert[j+1];
	                    sortert[j+1] = temp;
	                }
	       
	}
}
