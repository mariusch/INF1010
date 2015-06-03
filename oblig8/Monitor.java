/**
* Minitor for FinnAntall
* 
* @author mariusch
* @version 25.03.15
*/

public class Monitor {

	private static int antall = 0;

	/**
	 * Setter antall fun fra tråder
	 * @param nyttAntall antallet tråden fant
	 */
	public static synchronized void settAntall(int nyttAntall) {
		antall = antall + nyttAntall;
	}

	/**
	 * Henter totalt antall funnet 
	 * @return antall funnet
	 */
	public static synchronized int hentAntall() {
		return antall;
	}

}