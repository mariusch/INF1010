/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

public class Main {

	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");

		if (args.length == 1) {
			Sudoku sudoku = new Sudoku();
			System.out.println("Leser brett fra " + args[0]); 
			sudoku.lesFil(args[0]);
			sudoku.start();
			sudoku.skrivTilSkjerm();
		} else if (args.length == 2) {
			Sudoku sudoku = new Sudoku();
			System.out.println("Leser brett fra " + args[0] + " og lagrer til " + args[1]); 
			sudoku.lesFil(args[0]);
			sudoku.start();
			sudoku.skrivTilFil(args[1]);
		} else {
			System.out.println("Starter GUI");
			startGUI();

		}
	}

	private static void startGUI() {

		GUI.launch(GUI.class);
	}
}