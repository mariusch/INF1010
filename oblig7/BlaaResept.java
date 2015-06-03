/**
* Klasse for BlaaResept
* 
* Subklasse av Resept
* Gratis - sterkt subsidiert
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class BlaaResept extends Resept {

	double pris = 0;

	/**
	 * Oppretter BlaaResept - som er gratis
	 * @param  legemiddel Legemiddelet paa resepten
	 * @param  lege       Legen som har skrevet ut
	 * @param  persId     Personen som eier resepten
	 * @param  reit       antall ganger gyldig
	 * @return            objektet
	 */
	public BlaaResept(Legemiddel legemiddel, Lege lege, int persId, int reit) {
		super(legemiddel, lege, persId, reit);
	}
}