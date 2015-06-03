/**
* Klasse for EnkelReseptListe
* 
* Itererbar
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

import java.util.Iterator;

public class EnkelReseptListe implements Iterable<Resept>{
	
	protected Node head, tail;
	protected int antall;

	/**
	 * Indre Node-klasse til lenkelisten
	 */
	protected class Node {
		Node next;
		Resept data;

		protected Node(Resept data){
			this.data = data;
			antall++;
		}
		protected Resept getData(){
			return this.data;
		}
	}

	/**
	 * Setter inn resept FIFO
	 * @param  res Resept som skal inn
	 * @return     true hvis satt inn
	 */
	public boolean settInn(Resept res){

		Node tmp = head;

		//Sjekker foerst om tom
		if (tmp == null){
			head = new Node(res);
			tail = head;
			return true;
		}
		//Finner neste som peker på null
		while(tmp.next != null){
			tmp = tmp.next;
		}

		tmp.next = new Node(res);
		tail = tmp.next;
		return true;
	}

	/**
	 * Oppretter iterator
	 * @return iteratoren
	 */
	public Iterator<Resept> iterator() {
		return new ListeIterator();
	}

	/**
	 * Finner objekt ut i fra nummer. Kaster unntak hvis ikke
	 * @param  idNr unike idNret til resepten
	 * @return      reseptobjektet
	 */
	public Resept finn(int idNr){

		try {
			for (Resept r : this) {
				if (r.getIdNr() == idNr) {
					return r;
				}
			}
			throw new IngenReseptException();

		} catch (IngenReseptException e) {
			System.out.println(e.feilMelding());
			return null;
		}
	}

	public boolean taUt(int id) {
		Resept r = finn(id);
		int reit = r.getReit();
		if (reit != 0) {
			r.settReit();
			return true;
		} 
		return false;
	}

	/**
	 * Unntaksklasse for ingen resepter
	 */
	public class IngenReseptException extends Exception{
		
		public String feilMelding() {
			return "Ugyldig reseptnummer.";
		}
	}

	/**
	 * Iterator for lenkelisten
	 */
	private class ListeIterator implements Iterator<Resept> {
      int teller = 0; 
      Node nodeNext = head;
       
       public boolean hasNext() {
       		return (teller < antall);
       }

       public void remove() {

       }

      public Resept next() {
      	Resept tmp = nodeNext.data;
      	teller++;
      	nodeNext = nodeNext.next;
      	return tmp;
       }
   }

}