/**
* Grensesnitt for utlaan av boker
* 
* @author mariusch
* @version 09.02.15
*/

public interface TilUtlaan {

	/**
	 * Metode for å låne ut boken.
	 * @param  navn Lånerens navn
	 * @return      true hvis boken ble lånt ut. False ellers.
	 */
	public boolean laan(String navn);

	/**
	 * Returnerer boken som blir sendt med som parameter.
	 * Gjør så boken kan lånes ut på nytt
	 */
	public void retur();
}