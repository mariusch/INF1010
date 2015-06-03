class Fastlege extends Lege implements KommuneAvtale {
	
	private int avtaleNummer;

	public Lege(String navn, int avtaleNummer) {

		super(navn);
		this.avtaleNummer = avtaleNummer;
	}

	public int getAvtaleNummer() {
		return avtaleNummer;
	}
}