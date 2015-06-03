public class Main {
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();

		if (args.length == 1) {
			System.out.println("Leser brett fra " + args[0]); 
			sudoku.lesFil(args[0]);
			sudoku.start();
			sudoku.skrivTilSkjerm();
		} else if (args.length == 2) {
			System.out.println("Leser brett fra " + args[0] + " og lagrer til " + args[1]); 
			sudoku.lesFil(args[0]);
			sudoku.start();
			sudoku.skrivTilFil(args[1]);
		} else {
			System.out.println("Starter GUI");
		}	
	}
}