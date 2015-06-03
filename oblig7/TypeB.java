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

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "pille" + ", " + "b" + ", " + this.pris + ", " + this.antall + ", " + this.virkestoff + ", " + this.vanedannendeVerdi;
	}

	public String getType(){
		return "Pille B";
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Antall: " + this.antPiller() + " stk");
		System.out.println("Virkestoff: " + this.virkestoff());
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

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "mikstur" + ", " + "b" + ", " + this.pris + ", " + this.mengde + ", " + this.virkestoff + ", " + this.vanedannendeVerdi;
	}

	public String getType(){
		return "Mikstur B";
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Mengde: " + this.mengde() + " mg");
		System.out.println("Virkestoff: " + this.virkestoff());
	}
}