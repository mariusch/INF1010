/**
* Klasse for Legemiddel-TypeB-Pille (Fast form)
* 
* Vanedannende Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class PilleTypeB extends Pille{

	private int vanedannendeVerdi;

	/**
	 * Konstruktør for PilleTypeB
	 * @param  navn               Navnet på legemiddelet
	 * @param  pris               prisen
	 * @param  antall             antallet i esken
	 * @param  virkestoff         mengde virkestoff
	 * @param  vanedannendeVerdi  vanedannendeVerdi verdien
	 * @return                    objektet
	 */
	public PilleTypeB(String navn, double pris, int antall, double virkestoff, int vanedannendeVerdi) {
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

	/**
	 * MiksturTypeB
	 * @param  navn               Navnet på legemiddelet    
	 * @param  pris               prisen
	 * @param  mengde             mengde i miksturen
	 * @param  virkestoff         mengde virkestoff
	 * @param  vanedannendeVerdi  vanedannendeVerdi verdien
	 * @return                    objektet
	 */
	public MiksturTypeB(String navn, double pris, int mengde, double virkestoff, int vanedannendeVerdi) {
		super(navn, pris, mengde, virkestoff);
		this.vanedannendeVerdi = vanedannendeVerdi;
	}
}