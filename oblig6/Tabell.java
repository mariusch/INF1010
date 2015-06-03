/**
* Klasse for Tabell
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

import java.util.Iterator;

class Tabell<T> implements AbstraktTabell<T>{

	@SuppressWarnings("unchecked")
    private T[] beholder;
    private int antall = 0;

    /**
     * Kontstruktoer som oppretter beholder
     * @param  antall gir antall plasser i beholderen
     */
	@SuppressWarnings("unchecked")
    public Tabell(int antall) {
    	beholder = (T[]) new Object[antall];
    }

    /**
     * Sett inn på plass i arrayen
     * @param  pos    skal være objektets unike nr
     * @param  objekt objektet som skal inn
     * @return        true hvis satt inn og ledig
     */
    public boolean settInn(int pos, T objekt) {
    	if (beholder[pos] == null) {
    		beholder[pos] = objekt;
    		antall++;
    		return true;
    	}
    	return false;
    }

    /**
     * Finner objekt ut i fra plass
     * @param  pos plassen det står på (unike nr til objektet)
     * @return     objektet hvis funnet, ellers null
     */
    public T finn(int pos) {
    	return beholder[pos];
    }

    /**
     * Oppretter ny iterator
     * @return iterator
     */
    public Iterator<T> iterator() {
		  return new TabellIterator();
	}

  /**
   * Iteratorklasse
   */
	private class TabellIterator implements Iterator<T> {
		private int teller = 0;
       
       public boolean hasNext() {
       		if (teller < antall) {
       			teller++;
       			return true;
       		}
       		teller++;
       		return false;
       }

       public void remove() {
       }

       public T next() {
		   return beholder[teller-1];
       }
   }  

}