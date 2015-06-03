/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

import java.util.*;

public class Felt {
	private int id;
	private ArrayList<Rute> ruter = new ArrayList<>();
	private Brett brett;
	
	public Felt(int id, Brett brett) {
		this.id = id;
		this.brett = brett;
	}

	public String toString() {
		return id + "";
	}

	public void settRute(Rute r) {
		ruter.add(r);
	}

	public Brett getBrett() {
		return brett;
	}

	//true hvis feltet inneholder verdien allerede
	public boolean inneholder(int verdi) {
		boolean finnes = false;
		for (Rute rute : ruter) {
			int ruteVerdi = rute.getVerdi();
			if (verdi == ruteVerdi && verdi != 0) {
				finnes = true;
			}
		}
		return finnes;
	}

}

class Kolonne extends Felt {
	public Kolonne(int id, Brett brett) {
		super(id, brett);
	}
}

class Rad extends Felt{
	public Rad(int id, Brett brett) {
		super(id, brett);
	}

}

class Boks extends Felt{ 
	public Boks(int id, Brett brett) {
		super(id, brett);
	}
}
