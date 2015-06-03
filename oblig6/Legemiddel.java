/**
* Klasse for Legemidler
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

abstract class Legemiddel {
	
	private static int teller = 0;
	private int prodNr;
	private String navn;
	private double pris;

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

	/**
	 * get metode for prodNr
	 * @return [description]
	 */
	public int getProdNr() {
		return prodNr;
	}
}