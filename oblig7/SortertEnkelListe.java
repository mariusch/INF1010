/**
* Klasse for SortertEnkelListe
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

import java.util.Iterator;

class SortertEnkelListe<T extends Comparable<T> & Lik> implements AbstraktSortertEnkelListe<T> {

	private Node head, tail;
	private int antall;

	/**
	 * Nodeklasse for lenkeliste
	 */
	private class Node {
		Node next;
		T data;

		private Node(T data){
			this.data = data;
			antall++;
		}
		private T getData(){
			return this.data;
		}
	}

	/**
	 * Setter inn objektet i sortert rekkefølge - minste først
	 * @param  objekt objektet som skal inn
	 * @return        true hvis satt inn
	 */
	public boolean settInn(T objekt) {
		Node tmp = head;
		Node tmpForrige = head;

		//1. Tom liste - ingen objekter aa sammenligne med
		if (tmp == null) {
			head = new Node(objekt);
			tail = head;
			return true;
		}

		//2. Kun ett objekt i lista - skal det nye settes foran eller bak dette maa det også legges til head eller tail
		// Om objektet er likt det som allerede ligger der legges det bak det eksisterende
		else if(tmp.next == null) {
			Node nyNode = new Node(objekt);
			if(tmp.data.compareTo(objekt) >= 0){
				nyNode.next = tmp;
				head = nyNode;
				tail = tmp;
				return true;
			} else {
				tmp.next = nyNode;
				tail = nyNode;
				return true;
			}
		}

		//3. Objektet skal legges forrest i lista
		else if(tmp.data.compareTo(objekt) >= 0) {
			Node nyNode = new Node(objekt);
			nyNode.next = head;
			head = nyNode;
			return true;
		}

		//4. Objektet skal plasseres midt i listen eller bakerst
		while (tmp.data.compareTo(objekt) <= 0) {
			if (tmp.next == null){ 
				Node nyNode = new Node(objekt);
				tmp.next = nyNode;
				tail = nyNode;
				return true;
			}
			else{
				tmpForrige = tmp;
				tmp = tmp.next;
			}
		}

		//5. tmp er stoerre eller lik objektet
		Node nyNode = new Node(objekt);
		nyNode.next = tmp;
		tmpForrige.next = nyNode;
		return true;
	}

	/**
	 * Finner objekt basert på String
	 * @param  key søkeord
	 * @return     objektet hvis match, ellers null
	 */
	public T finn(String key){
		for (T t : this) {
			if (t.samme(key)) {
				return t;
			}
		}
		return null;
	}

	/**
	 * Oppretter iterator
	 * @return iterator for listen
	 */
	public Iterator<T> iterator() {
		return new ListeIterator();
	}

	/**
	 * Iteratorklassen
	 */
	private class ListeIterator implements Iterator<T> {
      int teller = 0; 
      Node nodeNext = head;
       
       public boolean hasNext() {
       	return (teller < antall);
       }

       public void remove() {

       }

      public T next() {
      	T tmp = nodeNext.data;
      	teller++;
      	nodeNext = nodeNext.next;
      	return tmp;
       }
   }
		
}