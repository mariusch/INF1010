/**
* Klasse for HvitResept
* 
* Subklasse av Resept
* Koster penger
* 
* @author mariusch
* @version 24.02.15
*/

class HvitResept extends Resept {
	
	public HvitResept(Legemiddel legemiddel, Lege skrevetUtAv, int eier, int reit) {
		super(legemiddel, skrevetUtAv, eier, reit);
	}
}