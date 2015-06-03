/**
* Klasse for BlaaResept
* 
* Subklasse av Resept
* Gratis - sterkt subsidiert
* 
* @author mariusch
* @version 24.02.15
*/

class BlaaResept extends Resept {

	public BlaaResept(Legemiddel legemiddel, Lege skrevetUtAv, int eier, int reit) {
		super(legemiddel, skrevetUtAv, eier, reit);
	}

	public double pris() {
		return 0;
	}
}