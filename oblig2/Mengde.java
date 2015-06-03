/**
* Generisk klasse for lenkelister
* 
* @author mariusch
* @version 02.02.15
*/

public class Mengde<E> {

	private Node<E> forste, siste;
	private int antall;
	
	/**
	 * KRAV: Sjekker om mengden er tom
	 * @return true hvis tom
	 */
	public boolean tom() {
		return forste == null;
	}

	/**
	 * KRAV: Legger objekt til i lenken
	 * @param  e Objektet som legges til Node
	 * @return   false hvis det finnes fra før
	 */
	public boolean leggTil(E e) {
		//Sjekker om inneholder
		if (inneholder(e)) {
			return false;
		}
		//Sjekker om tomt
		else if (tom()) {
			Node<E> n = new Node<E>(e);
			forste = n;
			siste = n;
			antall++;
			return true;
		}
		//Legger til
		else {
			Node<E> n = new Node<E>(e);
			siste.neste = n;
			siste = n;
			antall++;
			return true;
		}
	}

	/**
	 * KRAV: FIFO - Fjerner det som har ligget lengst
	 * @return Objektet som tas ut, eller null hvis menge tom
	 */
	public E fjernEldste() {
		//Sjekker om mengde er tom
		if (forste == null) {
			return null;
		}
		//Sjekker om kun et element
		else if (forste == siste) {
			Node<E> tmp = forste;
			forste = null;
			siste = null;
			antall = 0;
			return tmp.data;
		} else {
			//Kobler fra forste
			Node<E> tmp = forste;
			forste = forste.neste;
			antall--;
			return tmp.data;
		}
	}

	/**
	 * KRAV: LIFO - Fjerner det som ble lagt inn sist
	 * @return Objektet som tas ut, eller null hvis menge tom
	 */
	public E fjernNyeste() {
		//Sjekker om mengde er tom
		if (forste == null) {
			return null;
		}
		//Sjekker om kun et element
		if (forste == siste) {
			Node<E> tmp = siste;
			forste = null;
			siste = null;
			antall = 0;
			return tmp.data;
		}
		//Kobler fra siste
		for (Node<E> i = forste; i.neste != null; i = i.neste) {
			if (i.neste.neste == null) {
				Node<E> tmp = i.neste;
				siste = i;
				i.neste = null;
				antall--;
				return tmp.data;
			}
		}
		return null;
	}

	/**
	 * KRAV: Sjekker om objektet finnes i lenken
	 * @param  e Objektet som sjekkes
	 * @return   true hvis det finnes i lenken
	 */
	public boolean inneholder(E e) {
		//Sjekker at ikke tom
		if (forste == null) {
			return false;
		}
		//første
		if (forste != null) {
			if (forste.data == e) {
				return true;
			}
		}
		//siste
		if (siste != null) {
			if (siste.data == e) {
				return true;
			}
		}
		//alt i mellom
		for (Node<E> n = forste; n.neste != null ; n = n.neste) {
			if (n.data == e) {
				return true;
			}
		}
		return false;
	}

	private class Node<E> {
		E data;
		Node<E> neste;

		public Node(E data) {
			this.data = data;
			neste = null;
		}
	}

}