
public class Student {
	private int snr;
	private String navn;
	
	public Student(int snr, String navn) {
		this.snr = snr;
		this.navn = navn;
	}
	
	@Override
	public int hashCode() {
		return Integer.toString(snr).hashCode();
	}
}
