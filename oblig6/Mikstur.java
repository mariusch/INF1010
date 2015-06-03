/**
* Interface for Mikstur (Flytende form)
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

interface MiksturInterface {
	
	/**
	 * Mengde virkestoff i cm3
	 * @return mengde virkestoff i flasken
	 */
	public int mengde();

	/**
	 * Hvor mye virkestoff det er pr cm3
	 * @return mengde virkestoff
	 */
	public double virkestoff();
}


/**
* Klasse for Mikstur (Flytende form)
* 
* Subklasse av Legemiddel, implementerer MiksturInterface
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

abstract class Mikstur extends Legemiddel implements MiksturInterface {

	private int mengde;
	private double virkestoff;

	/**
	 * Konstruktør for Mikstur
	 * @param  navn       Navnet på legemiddelet
	 * @param  pris       prisen på legemiddelet
	 * @param  mengde     mengden
	 * @param  virkestoff virkestoffet
	 * @return            objektet
	 */
	public Mikstur(String navn, double pris, int mengde, double virkestoff) {
		super(navn, pris);
		this.mengde = mengde;
		this.virkestoff = virkestoff;
	}

	/**
	 * get metode for mengde
	 * @return nummer mengde
	 */
	public int mengde() {
		return mengde;
	}

	/**
	 * get metode for virkestoff
	 * @return antall
	 */
	public double virkestoff() {
		return virkestoff;
	}
}