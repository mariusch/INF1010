/**
* Interface for Piller (Fast form)
* 
* @author mariusch
* @version 24.02.15
*/

interface PilleInterface {
	
	/**
	 * Antall piller i esken
	 * @return antall
	 */
	public int antPiller();

	/**
	 * Hvor mye virkestoff det er i en pille
	 * @return mengde virkestoff
	 */
	public int virkestoff();
}

/**
* Klasse for Piller (Fast form)
* 
* Subklasse av Legemiddel, implementerer PilleInterface
* 
* @author mariusch
* @version 24.02.15
*/

abstract class Pille extends Legemiddel implements PilleInterface {

	private int antall;
	private int virkestoff;

	public Pille(String navn, double pris, int antall, int virkestoff) {
		super(navn, pris);
		this.antall = antall;
		this.virkestoff = virkestoff;
	}

	public int antPiller() {
		return antall;
	}

	public int virkestoff() {
		return virkestoff;
	}

}