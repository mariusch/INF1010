/**
* Klasse for persjoner
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class Person {
	
	private static int teller = 0;
	private String navn;
	private String personNr;
	private String adresse;
	private String postNr;
	private int idNr;
	private YngsteForstReseptListe reseptListe;

	/**
	 * Konstruktør for person
	 * @param  navn     navnet på personen
	 * @param  personNr personNummeret
	 * @param  adresse  Adressen
	 * @param  postNr   Postnr som string, for postnr som starter på 0
	 * @return          objektet
	 */
	public Person(String navn, String personNr, String adresse, String postNr) {
		this.idNr = teller;
		this.navn = navn;
		this.personNr = personNr;
		this.adresse = adresse;
		this.postNr = postNr;
		teller++;

		reseptListe = new YngsteForstReseptListe();
	}

	/**
	 * toString for navn
	 * @return navnet på personen
	 */
	public String toString() {
		return navn;
	}

	/**
	 * get metode for personens reseptliste
	 * @return reseptlisten
	 */
	public YngsteForstReseptListe getReseptListe() {
		return reseptListe;
	}

	/**
	 * Get metode for idNummeret (ikke personNR)
	 * @return unikt idNr
	 */
	public int getIdNr() {
		return idNr;
	}
}