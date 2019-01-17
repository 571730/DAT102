package no.hib.dat102.oppgave2;

public class Datakontakt {
	private int antallMedlemmer;
	private Medlem[] medlemstabell;
	
	private final static int STDK = 100;
	
	public Datakontakt(int storrelse) {
		antallMedlemmer = 0;
		medlemstabell = new Medlem[storrelse];
	}
	
	public Datakontakt() {
		this(STDK);
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}

	public void setAntallMedlemmer(int antallMedlemmer) {
		this.antallMedlemmer = antallMedlemmer;
	}

	public Medlem[] getMedlemstabell() {
		return medlemstabell;
	}

	public void setMedlemstabell(Medlem[] medlemstabell) {
		this.medlemstabell = medlemstabell;
	}

	public void leggTilMedlem(Medlem medlem){
		if(antallMedlemmer == medlemstabell.length) {
			utvid();
		}
		medlemstabell[antallMedlemmer] = medlem;
		antallMedlemmer++;
	}
	
	public void utvid() {
		Medlem[] utvidetTab = new Medlem[medlemstabell.length * 2];
		System.arraycopy(medlemstabell, 0, utvidetTab, 0, antallMedlemmer);
		medlemstabell = utvidetTab;
	}
	
	public int finnMedlemsIndex(String medlemsnavn) {
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemstabell[i].getNavn().equals(medlemsnavn)) {
				return i;
			}
		}
		return -1;
	}
	
	public int finnPartnerFor(String medlemsnavn) {
		int medlemSok = finnMedlemsIndex(medlemsnavn);
		Medlem mSok = medlemstabell[medlemSok];
		
		for(int i = 0; i < antallMedlemmer; i++) {
			if(i != medlemSok && mSok.passerTil(medlemstabell[i])) {
				mSok.setStatusIndex(i);
				medlemstabell[i].setStatusIndex(medlemSok);
				return i;
			}
		}
		return -1;
	}
	
	public void tilbakestillStausIndeks(String medlemsnavn) {
		int medlemSok = finnMedlemsIndex(medlemsnavn);
		int partnerIndex = medlemstabell[medlemSok].getStatusIndex();
		
		if(partnerIndex != -1) {
			medlemstabell[medlemSok].setStatusIndex(-1);
			medlemstabell[partnerIndex].setStatusIndex(-1);
		}
	}
}
