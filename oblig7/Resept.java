/**
* Klasse for Resept
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

abstract class Resept {

	private static int teller = 0;
	private int idNr;
	private Legemiddel legemiddel;
	private Lege lege;
	private int persId;
	private int reit;

	/**
	 * Konstruktør for Resept
	 * @param  legemiddel Legemiddelet det gjelder
	 * @param  lege       legen som skrev ut
	 * @param  persId     personens id
	 * @param  reit       antall ganger gydlig
	 * @return            objektet
	 */
	public Resept(Legemiddel legemiddel, Lege lege, int persId, int reit) {
		this.idNr = teller;
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.persId = persId;
		this.reit = reit;
		teller++;


//Nye metoder lagt til ifm. statistikk 22. mars

		if (legemiddel instanceof Pille){
			Pille p = (Pille) legemiddel;
			lege.settVirkestoffPille(p.virkestoff()); //virkestoff() ligger i Pille

			if (legemiddel instanceof PilleTypeA){
				PilleTypeA pl = (PilleTypeA) legemiddel;
				lege.oekTypeA(); //Lege-fil må ha oekTypeA() som ++ teller av typeAresepter
			}
		}
		else if(legemiddel instanceof Mikstur){
			Mikstur m = (Mikstur) legemiddel;
			lege.settVirkestoffMikstur(m.virkestoff()); //virkestoff() ligger i Mikstur

			if(legemiddel instanceof MiksturTypeA){
				MiksturTypeA ms = (MiksturTypeA) legemiddel;
				lege.oekTypeA(); //Lege-fil må ha oekTypeA() som ++ teller av typeAresepter
			}
		}
	}

	/**
	 * toString med navn og hvilken klasse objektet er
	 * @return navn og klassetype
	 */
	public String toString() {
		return "Reseptnr: " + idNr + " Legemiddel: " + legemiddel.getNavn();
	}

	/**
	 * get metode for idNr
	 * @return unikt nr
	 */
	public int getIdNr() {
		return idNr;
	}

	public int getReit() {
		return reit;
	}

	public void settReit() {
		reit--;
	}

	public int getPersId() {
		return persId;
	}

	public Legemiddel getLegemiddel(){
		return legemiddel;
	}

	public Lege getLege(){
		return lege;
	}

	public String skrivFil() {
		if (this instanceof BlaaResept) {
			return this.idNr + ", " + "blå" + ", " + this.persId + ", " + lege.getNavn() + ", " + legemiddel.getProdNr() + ", " + this.reit;

		} else {
			return this.idNr + ", " + "hvit" + ", " + this.persId + ", " + lege.getNavn() + ", " + legemiddel.getProdNr() + ", " + this.reit;
		}
	}
}