/**
* Grensesnitt for utlaan av boker
* 
* @author mariusch
* @version 09.02.15
*/

public class Hylle<T> implements GenHylle<T> {

	private int antall;
	@SuppressWarnings("unchecked")
    private T[] hylle;

    /**
     * Kontstruktør som oppretter hylleplasser
     * @param  antall gir antall plasser i hyllen
     */
	@SuppressWarnings("unchecked")
    public Hylle( int antall) {
    	hylle = (T[]) new Object[antall];
    	this.antall = antall;
    }

    /**
	 * Setter inn objekt paa en gitt plass, hvis ledig
	 * @param  plass plassen det skal settes inn paa
	 * @param  ting  objektet som skal settes paa hyllen
	 * @return       true hvis plasert, false ellers
	 */
	public boolean settInn(int plass, T ting) {
		//Sjekk nullpointer
		if (nullpointer(plass, antall)) {
			return false;
		}
		//Sett inn hvis ledig
		if (ledig(plass)) {
			hylle[plass] = ting;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Tar ut objektet og hylles settes hyllen ledig
	 * @param  plass plassen det skla taas ut fra
	 * @return       objektet som ble tatt ut, null hvis tull
	 */
	public T taUt(int plass) {
		//Sjekk nullpointer
		if (nullpointer(plass, antall)) {
			return null;
		}
		//Ta ut hvis finnes
		if (hylle[plass] != null) {
			T tmp = hylle[plass];
			hylle[plass] = null;
			return tmp;
		} else {
			return null;
		}
	}

	/**
	 * Sjekker om en flass er ledig
	 * @param  plass plassen som sjekkes
	 * @return       true hvis ledig
	 */
	public boolean ledig(int plass) {
		//Sjekk nullpointer
		if (nullpointer(plass, antall)) {
			return false;
		}
		//Sjekk om ledig
		if (hylle[plass] == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Storrelsen paa hyllen
	 * @return int antall storrelse(array)
	 */
	public int storrelse() {
		return this.antall;
	}

	/**
	 * Sjekker om plassen er gyldig
	 * @param  plass  plassen det gjelder
	 * @param  antall plasser i hyllen
	 * @return        true om plassen gir nullpointer
	 */
	private boolean nullpointer(int plass, int antall) {
		if (plass < 0 || plass >= antall) {
			return true;
		} else {
			return false;
		}
	}

}