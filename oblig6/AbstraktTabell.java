/**
* Interface for AbstraktTabell<T>
* 
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

interface AbstraktTabell<T> extends Iterable<T> {
	
	/**
	 * Sett inn objekt paa gitt posisjon
	 * @param  pos    index objekt skal settes paa
	 * @param  objekt objektet som skal inn
	 * @return        true hvis satt inn
	 */
	public boolean settInn(int pos, T objekt);

	/**
	 * Leter etter objekt paa gitt index
	 * @param  pos index for gitt objekt
	 * @return     objektet paa gitt plass, ellers null
	 */
	public T finn(int pos);

}

