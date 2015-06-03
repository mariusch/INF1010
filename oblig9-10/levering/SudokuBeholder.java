import java.util.*;


public class SudokuBeholder {
	private int antallLosninger;
	private final int MAKS;
	private ArrayList<Losning> losninger;


	public SudokuBeholder() {
		this.antallLosninger = 0;
		MAKS = 2500;
		losninger =  new ArrayList<>(MAKS);
	}

	//Hvis flere enn 2500 løsninger skal kun teller gå opp
	public void settInn(Losning brett) {
		antallLosninger++;

		if (losninger.size() < 2500) {
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