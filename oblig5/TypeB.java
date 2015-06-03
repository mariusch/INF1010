/**
* Klasse for Legemiddel-TypeB-Pille (Fast form)
* 
* Vanedannende Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @version 24.02.15
*/

class PilleTypeB extends Pille{

	private int vanedannendeVerdi;

	public PilleTypeB(String navn, double pris, int antall, int virkestoff, int vanedannendeVerdi) {
		super(navn, pris, antall, virkestoff);
		this.vanedannendeVerdi = vanedannendeVerdi;
	}
}

/**
* Klasse for Legemiddel-TypeB-Mikstur (Flytende form)
* 
* Vanedannende Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @version 24.02.15
*/

class MiksturTypeB extends Mikstur{
	
	private int vanedannendeVerdi;

	public MiksturTypeB(String navn, double pris, int antall, int virkestoff, int vanedannendeVerdi) {
		super(navn, pris, antall, virkestoff);
		this.vanedannendeVerdi = vanedannendeVerdi;
	}
}