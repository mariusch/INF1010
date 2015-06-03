/**
* Klasse for Legemiddel-TypeA-Pille (Fast form)
* 
* Narkotisk Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @version 24.02.15
*/

class PilleTypeA extends Pille {
	
	private int narkotiskVerdi;

	public PilleTypeA(String navn, double pris, int antall, int virkestoff, int narkotiskVerdi) {
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
* @version 24.02.15
*/

class MiksturTypeA extends Mikstur  {
	
	private int narkotiskVerdi;

	public MiksturTypeA(String navn, double pris, int antall, int virkestoff, int narkotiskVerdi) {
		super(navn, pris, antall, virkestoff);
		this.narkotiskVerdi = narkotiskVerdi;
	}
}