/**
* Interface for Mikstur (Flytende form)
* 
* @author mariusch
* @version 24.02.15
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
	public int virkestoff();
}


/**
* Klasse for Mikstur (Flytende form)
* 
* Subklasse av Legemiddel, implementerer MiksturInterface
* 
* @author mariusch
* @version 24.02.15
*/

abstract class Mikstur extends Legemiddel implements MiksturInterface {

	private int mengde;
	private int virkestoff;

	public Mikstur(String navn, double pris, int mengde, int virkestoff) {
		super(navn, pris);
		this.mengde = mengde;
		this.virkestoff = virkestoff;
	}

	public int mengde() {
		return mengde;
	}

	public int virkestoff() {
		return virkestoff;
	}
}