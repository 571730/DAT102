package no.hvl.dat102;

public class QuickSortering implements Sortering{
	private Integer[] sortert;

	public Integer[] getSortert() {
		return sortert;
	}
	
	public void sorter(Integer[] liste) {
		sortert = liste;
		quickSort(0, sortert.length-1);
	}
	
	
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = sortert[lowerIndex+(higherIndex-lowerIndex)/2];
        //int pivot = sortert[lowerIndex];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (sortert[i] < pivot) {
                i++;
            }
            while (sortert[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        Integer temp = sortert[i];
        sortert[i] = sortert[j];
        sortert[j] = temp;
    }
}
