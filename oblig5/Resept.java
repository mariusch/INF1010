/**
* Klasse for Resept
* 
* @author mariusch
* @version 24.02.15
*/

abstract class Resept {

	private static int idNr = 0;
	private Legemiddel legemiddel;
	private Lege skrevetUtAv;
	private int eier;
	private int reit;

	public Resept(Legemiddel legemiddel, Lege skrevetUtAv, int eier, int reit) {
		this.idNr = idNr + 1;
		this.legemiddel = legemiddel;
		this.skrevetUtAv = skrevetUtAv;
		this.eier = eier;
		this.reit = reit;
	}
}