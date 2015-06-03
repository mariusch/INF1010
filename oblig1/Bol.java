/**
* Generisk klasse som kan ta i mot mus
* 
*
* @author mariusch
* @version 28.01.15
*/

public class Bol<T> {

	private T beboer;

	/**
	 * Get metode for det som er i beholderen
	 * @return returnerer beboeren
	 */
	public T beboer() {
		return beboer;
	}

	/**
	 * Setter et object inn i beholderen
	 * @param beboer det som skal settes inn
	 */
	public void settInn(T beboer) {
		this.beboer = beboer;
	}

	/**
	 * Tar objektet ut av beholderen
	 * @return det som taas ut
	 */
	public T taUt() {
		T mellom = beboer;
		beboer = null;
		return mellom;	
	}

	/**
	 * Sjekker om bolet er tomt
	 * @return true hvis det er tomt
	 */
	public boolean tomt() {
		if(beboer == null) {
			return true;
		} else {
			return false;
		}
	}	
}