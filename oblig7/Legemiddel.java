/**
* Klasse for Legemidler
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

abstract class Legemiddel {
	
	private static int teller = 0;
	protected int prodNr;
	protected String navn;
	protected double pris;

	/**
	 * Konstruktør for legemiddel
	 * @param  navn Navnet på legemiddelet
	 * @param  pris pris det koster
	 * @return      objektet
	 */
	public Legemiddel(String navn, double pris) {
		this.prodNr = teller;
		this.navn = navn;
		this.pris = pris;
		teller++;
	}

	/**
	 * toString med navn og klassetype
	 * @return objektet
	 */
	public String toString() {
		return "Navn: "+ navn + " Type: " + this.getClass();
	}

	public String getNavn() {
		return navn;
	}

	public int getProdNr() {
		return this.prodNr;
	}

	public double getPris() {
		return this.pris;
	}

	public void skrivUtKvittering(Resept res){

		if (this instanceof PilleTypeA){
			PilleTypeA m = (PilleTypeA) res.getLegemiddel();
			m.skrivKvittering();
		}
		else if (this instanceof PilleTypeB){
			PilleTypeB m = (PilleTypeB) res.getLegemiddel();
			m.skrivKvittering();
		}
		else if (this instanceof PilleTypeC){
			PilleTypeC m = (PilleTypeC) res.getLegemiddel();
			m.skrivKvittering();
		}
		else if (this instanceof MiksturTypeA){
			MiksturTypeA m = (MiksturTypeA) res.getLegemiddel();
			m.skrivKvittering();
		}
		else if (this instanceof MiksturTypeB){
			MiksturTypeB m = (MiksturTypeB) res.getLegemiddel();
			m.skrivKvittering();
		}
		else if (this instanceof MiksturTypeC){
			MiksturTypeC m = (MiksturTypeC) res.getLegemiddel();
			m.skrivKvittering();
		}
	}
}