/**
* Klasse for Fastlege
* 
* Subklasse av Lege, implementerer KommuneAvtale
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class Fastlege extends Lege implements KommuneAvtale {
	
	private int avtaleNummer;

	/**
	 * Konstruktør for Fastlege. Tar inn avtalenr
	 * @param  navn         Unikt navn på legen
	 * @param  avtaleNummer avtalenr med kommunen
	 * @return              objektet
	 */
	public Fastlege(String navn, int avtaleNummer) {
		super(navn);
		this.avtaleNummer = avtaleNummer;
	}

	/**
	 * getmetode for avtalenr
	 * @return avtalenummeret
	 */
	public int getAvtaleNummer() {
		return avtaleNummer;
	}
}