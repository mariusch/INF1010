/**
* Klasse for Legemiddel-TypeA-Pille (Fast form)
* 
* Narkotisk Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class PilleTypeA extends Pille {
	
	private int narkotiskVerdi;

	/**
	 * Konstruktør for PilleTypeA
	 * @param  navn           Navnet på legemiddelet
	 * @param  pris           prisen
	 * @param  antall         antallet i esken
	 * @param  virkestoff     mengde virkestoff
	 * @param  narkotiskVerdi narkotiske verdien
	 * @return                objektet
	 */
	public PilleTypeA(String navn, double pris, int antall, double virkestoff, int narkotiskVerdi) {
		super(navn, pris, antall, virkestoff);
		this.narkotiskVerdi = narkotiskVerdi;
	}
}

/**
* Klasse for Legemiddel-TypeA-Mikstur (Flytende form)
* 
* Narkotisk Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class MiksturTypeA extends Mikstur  {
	
	private int narkotiskVerdi;

	/**
	 * MiksturTypeA
	 * @param  navn           Navnet på legemiddelet
	 * @param  pris           prisen
	 * @param  mengde         mengde i miksturen
	 * @param  virkestoff     mengde virkestoff
	 * @param  narkotiskVerdi narkotiske verdien
	 * @return                objektet
	 */
	public MiksturTypeA(String navn, double pris, int mengde, double virkestoff, int narkotiskVerdi) {
		super(navn, pris, mengde, virkestoff);
		this.narkotiskVerdi = narkotiskVerdi;
	}
}