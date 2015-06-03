/**
* Klasse for HvitResept
* 
* Subklasse av Resept
* Koster penger
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class HvitResept extends Resept {
	private double pris;
	
	/**
	 * Konstruktør for HvitResept
	 * @param  legemiddel Legemiddel objektet det gjelder
	 * @param  lege       Legen som skrev ut
	 * @param  persId     Personens id det gjelder
	 * @param  reit       antall ganger gyldig
	 * @param  pris       prisen
	 * @return            objektet
	 */
	public HvitResept(Legemiddel legemiddel, Lege lege, int persId, int reit, double pris) {
		super(legemiddel, lege, persId, reit);
		this.pris = pris;
	}
}