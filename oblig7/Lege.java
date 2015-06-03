/**
* Klasse for Lege
* 
* Subklasse av Person
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*
*/

class Lege implements Lik, Comparable<Lege> {
	
	protected String navn;
	private EldsteForstReseptListe reseptListe;
	private int typeAResepter = 0;
	private double virkestoffPille = 0;
	private double virkestoffMikstur = 0;

	/**
	 * Konstruktør for Lege
	 * @param  navn unikt navn på legen
	 * @return      objektet
	 */
	public Lege(String navn) {
		this.navn = navn;
		reseptListe = new EldsteForstReseptListe();
	}


//Nye metoder lagt til ifm. statistikk 22. mars

	public void oekTypeA(){
		typeAResepter++;
	}
	public int getTypeA(){
		return typeAResepter;
	}
	public void settVirkestoffPille(double mg){
		virkestoffPille = virkestoffPille + mg;
	}
	public void settVirkestoffMikstur(double mg){
		virkestoffMikstur = virkestoffMikstur + mg;
	}
	public double getVirkestoffPille(){
		return virkestoffPille;
	}
	public double getVirkestoffMikstur(){
		return virkestoffMikstur;
	}




	/**
	 * toString for legens navn
	 * @return Legens unike navn
	 */
	public String toString() {
		return navn;
	}

	/**
	 * get metode for navn
	 * @return Legens unike navn
	 */
	public String getNavn() {
		return this.navn;
	}

	/**
	 * get metode for legens reseptliste
	 * @return liste over legens resepter
	 */
	public EldsteForstReseptListe getReseptListe(){
		return reseptListe;
	}

	/**
	 * Sammenligner to navn
	 * Interface fra Lik
	 * @param  navn navn legens navn skal sjekkes mot
	 * @return      true hvis likt
	 */
	public boolean samme(String navn) {
		return this.navn.equalsIgnoreCase(navn);
	}

	/**
	 * Sammenligner legenes navn
	 * @param  t legeobjekt å sammenligne med
	 * @return   vanlig compareTo standard
	 */
	public int compareTo(Lege t) {
		return this.navn.compareTo(t.getNavn());
	}

	/**
	 * Oppretter Hvit Resept og legger i lister
	 * @param legemiddel Legemiddeles det gjelder
	 * @param persId     Personen som eier resepten
	 * @param reit       antall ganger gyldig
	 * @param pris       prisen
	 */
	public void skrivUtHvitResept(Legemiddel legemiddel, int persId, int reit, double pris) {
		HvitResept resept = new HvitResept(legemiddel, this, persId, reit, pris);
		//Legg til i: EldsteForstReseptListe - Denne legens reseptliste FIFO
		reseptListe.settInn(resept);
	}

	/**
	 * Oppretter Blaa Resept og legger i lister
	 * @param legemiddel Legemiddeles det gjelder
	 * @param persId     Personen som eier resepten
	 * @param reit       antall ganger gyldig
	 */
	public void skrivUtBlaaResept(Legemiddel legemiddel, int persId, int reit) {
		BlaaResept resept = new BlaaResept(legemiddel, this, persId, reit);
		//Legg til i: EldsteForstReseptListe - Denne legens reseptliste FIFO
		reseptListe.settInn(resept);
	}

	public String skrivFil() {
		return this.navn + ", " + "0";
	}
}