package no.hvl.dat102;

public class SumRecursion {
	public static void main(String[] args) {
		System.out.println(sum(100));
	}
	
	public static int sum(int num){
        if(num == 1){
            return 1;
        }
        else {
            return sum(num - 1) + num;
        }
    }

}
