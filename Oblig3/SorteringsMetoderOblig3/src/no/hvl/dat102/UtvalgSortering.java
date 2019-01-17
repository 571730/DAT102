package no.hvl.dat102;

public class UtvalgSortering implements Sortering{
	private Integer[] sortert;
	
	public void sorter(Integer[] liste) {
		sortert = liste;
		int n = sortert.length;
		 
        for (int i = 0; i < n-1; i++)
        {
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (sortert[j] < sortert[minIndex])
                    minIndex = j;
 
            int temp = sortert[minIndex];
            sortert[minIndex] = sortert[i];
            sortert[i] = temp;
        }
        
	}
}
