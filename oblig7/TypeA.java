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

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "pille" + ", " + "a" + ", " + this.pris + ", " + this.antall + ", " + this.virkestoff + ", " + this.narkotiskVerdi;
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Antall: " + this.antPiller() + " stk");
		System.out.println("Virkestoff: " + this.virkestoff());
	}

	public String getType(){
		return "Pille A";
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

	public String skrivFil() {
		return this.prodNr + ", " + this.navn + ", " + "mikstur" + ", " + "a" + ", " + this.pris + ", " + this.mengde + ", " + this.virkestoff + ", " + this.narkotiskVerdi;
	}

	public String getType(){
		return "Mikstur A";
	}

	public void skrivKvittering(){
		System.out.println("Legemiddel: " + this.getNavn() + " (" + this.getPris() + " kr)");
		System.out.println("Type: " + this.getType()); 
		System.out.println("Mengde: " + this.mengde() + " mg");
		System.out.println("Virkestoff: " + this.virkestoff());
	}

}