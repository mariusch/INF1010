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
		this.idNr = teller + 1;
		this.legemiddel = legemiddel;
		this.lege = lege;
		this.persId = persId;
		this.reit = reit;
		teller++;
	}

	/**
	 * toString med navn og hvilken klasse objektet er
	 * @return navn og klassetype
	 */
	public String toString() {
		return "Resept nr: " + idNr + " Type: " + this.getClass();
	}

	/**
	 * get metode for idNr
	 * @return unikt nr
	 */
	public int getIdNr() {
		return idNr;
	}
}