/**
* Klasse for persjoner
* 
* @author mariusch
* @version 24.02.15
*/

class Person {
	
	private String navn;
	private int personNr;
	private String adresse;
	private int postNr;
	private static int idNr = 0;

	public Person(String navn, int personNr, String adresse, int postNr) {
		this.idNr = idNr + 1;
		this.navn = navn;
		this.personNr = personNr;
		this.adresse = adresse;
		this.postNr = postNr;
	}
}