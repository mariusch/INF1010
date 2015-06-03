/**
* Klasse for Legemidler
* 
* @author mariusch
* @version 24.02.15
*/

abstract class Legemiddel {
	
	private static int prodNr = 0;
	private String navn;
	private double pris;

	public Legemiddel(String navn, double pris) {
		this.prodNr = prodNr + 1;
		this.navn = navn;
		this.pris = pris;
	}
}