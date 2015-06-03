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


public class SudokuBeholder {
	private int antallLosninger;
	private ArrayList<Losning> losninger;


	public SudokuBeholder() {
		this.antallLosninger = 0;
		int MAKS = 2500;
		losninger =  new ArrayList<>(MAKS);
	}

	public void settInn(Losning brett) {
		antallLosninger++;

        //Hvis flere enn 2500 løsninger skal kun teller gå opp
		if (losninger.size() <= 2500) {
			losninger.add(brett);
		}

	}

	public Losning taUt(int plass) {
		if (plass < losninger.size()) {
			return losninger.get(plass);
		}

		return null;
	}

	public int hentAntallLosninger() {
		return antallLosninger;
	}

	public ArrayList<Losning> getLosninger() {
		return losninger;
	}
}