/**
* Klasse for Legemiddel-TypeC-Pille (Fast form)
* 
* Vanlig Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @version 24.02.15
*/

class PilleTypeC extends Pille{

	public PilleTypeC(String navn, double pris, int antall, int virkestoff) {
		super(navn, pris, antall, virkestoff);

	}
}

/**
* Klasse for Legemiddel-TypeC-Mikstur (Flytende form)
* 
* Vanlig Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @version 24.02.15
*/

class MiksturTypeC extends Mikstur{

	public MiksturTypeC(String navn, double pris, int antall, int virkestoff) {
		super(navn, pris, antall, virkestoff);
	}
}