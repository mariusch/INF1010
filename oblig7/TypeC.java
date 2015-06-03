/**
* Klasse for Legemiddel-TypeC-Pille (Fast form)
* 
* Vanlig Legemiddel
* Subklasse av Legemiddel
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class PilleTypeC extends Pille{

	/**
	 * Konstruktør for PilleTypeC
	 * @param  navn           Navnet på legemiddelet
	 * @param  pris           prisen
	 * @param  antall         antallet i esken
	 * @param  virkestoff     mengde virkestoff
	 * @return                objektet
	 */
	public PilleTypeC(String navn, double pris, int antall, double virkestoff) {
		super(navn, pris, antall, virkestoff);
	}

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "pille" + ", " + "c" + ", " + this.pris + ", " + this.antall + ", " + this.virkestoff;
	}

	public String getType(){
		return "Pille C";
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Antall: " + this.antPiller() + " stk");
		System.out.println("Virkestoff: " + this.virkestoff());
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

	/**
	 * MiksturTypeC
	 * @param  navn           Navnet på legemiddelet
	 * @param  pris           prisen
	 * @param  mengde         mengde i miksturen
	 * @param  virkestoff     mengde virkestoff
	 * @return                objektet
	 */
	public MiksturTypeC(String navn, double pris, int mengde, double virkestoff) {
		super(navn, pris, mengde, virkestoff);
	}

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "mikstur" + ", " + "c" + ", " + this.pris + ", " + this.mengde + ", " + this.virkestoff;
	}

	public String getType(){
		return "Mikstur C";
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Mengde: " + this.mengde() + " mg");
		System.out.println("Virkestoff: " + this.virkestoff());
	}
}