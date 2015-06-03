/**
* Interface for Piller (Fast form)
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
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
	public double virkestoff();
}

/**
* Klasse for Piller (Fast form)
* 
* Subklasse av Legemiddel, implementerer PilleInterface
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

abstract class Pille extends Legemiddel implements PilleInterface {

	private int antall;
	private double virkestoff;

	public Pille(String navn, double pris, int antall, double virkestoff) {
		super(navn, pris);
		this.antall = antall;
		this.virkestoff = virkestoff;
	}

	public int antPiller() {
		return antall;
	}

	public double virkestoff() {
		return virkestoff;
	}

}