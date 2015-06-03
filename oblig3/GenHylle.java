/**
* Grensesnitt for utlaan av boker
* 
* @author mariusch
* @version 09.02.15
*/

public interface GenHylle<T> {

	/**
	 * Setter inn objekt paa en gitt plass, hvis ledig
	 * @param  plass plassen det skal settes inn paa
	 * @param  ting  objektet som skal settes paa hyllen
	 * @return       true hvis plasert, false ellers
	 */
	public boolean settInn(int plass, T ting);

	/**
	 * Tar ut objektet og hylles settes hyllen ledig
	 * @param  plass plassen det skla taas ut fra
	 * @return       objektet som ble tatt ut, null hvis tull
	 */
	public T taUt(int plass);

	/**
	 * Sjekker om en flass er ledig
	 * @param  plass plassen som sjekkes
	 * @return       true hvis ledig
	 */
	public boolean ledig(int plass);

	/**
	 * Storrelsen paa hyllen
	 * @return int antall storrelse(array)
	 */
	public int storrelse();
}