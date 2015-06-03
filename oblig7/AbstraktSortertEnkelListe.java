/**
* Interface for AbstraktSortertEnkelListe
* 
* Begrenser T til å også implementere Comparable<T> og Lik
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

interface AbstraktSortertEnkelListe<T extends Comparable<T> & Lik> extends Iterable<T> {

	/**
	 * Sette inn objekt, kjoer .sort etterpaa
	 * @param  objekt objektet som skal inn
	 * @return        true hvis satt inn
	 */
	public boolean settInn(T objekt);

	/**
	 * Finne objekt ut i fra noekkel
	 * @param  key det som skal finnes
	 * @return     objektet om det finnes, ellers null
	 */
	public T finn(String key);
}