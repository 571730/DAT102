package no.hvl.dat102;

public class Hanoi {
	private int totalDisks;
	//Modifikasjon
	private long antall;
	
	public long getAntall() {
		return antall;
	}

	/**
	 * Sets up the puzzle with the specified number of disks.
	 *
	 * @param disks
	 *            the number of disks to start the towers puzzle with
	 */
	public Hanoi(int disks) {
		totalDisks = disks;
	}

	/**
	 * Performs the initial call to moveTower to solve the puzzle. Moves the disks
	 * from tower 1 to tower 3 using tower 2.
	 */
	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}

	/**
	 * Moves the specified number of disks from one tower to another by moving a
	 * subtower of n-1 disks out of the way, moving one disk, then moving the
	 * subtower back. Base case of 1 disk.
	 *
	 * @param numDisks
	 *            the number of disks to move
	 * @param start
	 *            the starting tower
	 * @param end
	 *            the ending tower
	 * @param temp
	 *            the temporary tower
	 */
	private void moveTower(int numDisks, int start, int end, int temp) {
		if (numDisks == 1) {
			//moveOneDisk(start, end);
			antall++;
		}
		else {
			moveTower(numDisks - 1, start, temp, end);
			//moveOneDisk(start, end);
			antall++;
			moveTower(numDisks - 1, temp, end, start);
		}
	}

	/**
	 * Prints instructions to move one disk from the specified start tower to the
	 * specified end tower.
	 *
	 * @param start
	 *            the starting tower
	 * @param end
	 *            the ending tower
	 */
	private void moveOneDisk(int start, int end) {
		System.out.print("");
		//System.out.print("Move one disk from " + start + " to " + end);
	}

	public static void main(String[] args) {
		//4 disker
		System.out.println("\nKjorer med 4 disker");
		long tidStart = System.nanoTime();
		Hanoi towers = new Hanoi(4);
		towers.solve();
		long tidStop = System.nanoTime();
		System.out.println("Det tok " + (double)(tidStop-tidStart)/1000000 + "ms");
		System.out.println("Antall flytt: " + towers.getAntall());
		
		//16 disker
		System.out.println("\nKjorer med 16 disker");
		long tidStart2 = System.nanoTime();
		Hanoi towers2 = new Hanoi(16);
		towers2.solve();
		long tidStop2 = System.nanoTime();
		System.out.println("Det tok " + (double)(tidStop2-tidStart2)/1000000 + "ms");
		System.out.println("Antall flytt: " + towers2.getAntall());
		
		//32 disker
		System.out.println("\nKjorer med 32 disker");
		long tidStart3 = System.nanoTime();
		Hanoi towers3 = new Hanoi(32);
		towers3.solve();
		long tidStop3 = System.nanoTime();
		System.out.println("Det tok " + (double)(tidStop3-tidStart3)/1000000 + "ms");
		System.out.println("Antall flytt: " + towers3.getAntall());
	}

}
