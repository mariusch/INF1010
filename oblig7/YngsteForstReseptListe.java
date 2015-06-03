/**
* Klasse for YngsteForstReseptListe
* 
* Subklasse av EnkelReseptListe
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

class YngsteForstReseptListe extends EnkelReseptListe {
	
	/**
	 * Setter inn som stack(LIFO) og overskriver EnkelReseptListe sin FIFO
	 * @param  res resepten som skal inn
	 * @return     true hvis satt inn
	 */
	@Override  //LIFO - EnkelReseptListe er FIFO
	public boolean settInn(Resept res){

		if (head == null) {
			head = new Node(res);
			tail = head;
		} else {
			Node tmp = head;
			Node nyNode = new Node(res);
			head = nyNode;
			nyNode.next = tmp;
		}
		return true;
	}
}