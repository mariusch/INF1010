/**
* Klasse for Lege
* 
* Subklasse av Person
* 
* @author mariusch
* @version 24.02.15
*/

class Lege implements Lik {
	
	private String navn;

	public Lege(String navn) {
		this.navn = navn;
	}

	public boolean samme(String navn) {
		return false;
	}

}