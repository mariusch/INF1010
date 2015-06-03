/**
* Finner antall ord som forekommer i fil
*
* Velg antall tråder som skal dele på oppgaven som parameter
* Parametere: ord, filnavn, antTraader
* 
* @author mariusch
* @version 25.03.15
*/

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class FinnAntall {

	private static String ord;
	private static String filnavn;
	private static int antTraader;
	private static int antOrd;

    private static String[] ordliste;
    private static ArrayList<String[]> listeDeler = new ArrayList<>();
    private static CountDownLatch minBariere;
    private static Monitor monitor;

    /**
     * Indre klasse som gjør igjennom gitt array index
     *  Returnerer antall funn til monitor
     */
    class TelleTraad implements Runnable {

    	private int index;

    	public TelleTraad(int index) {
    		this.index = index;
    	}

		public void run() {
			System.out.println("Tråd " + index + " startet.");
			int teller = 0;
			for (String s : listeDeler.get(index-1)) {
				if (s.equals(ord)) {
					teller++;
				}
			}
			monitor.settAntall(teller);
			System.out.println("Tråd " + index + " ferdig. Returnerte: " + teller);
			minBariere.countDown();
		}
	}

	public static void main(String[] args) {
		monitor = new Monitor();

		//Leser parametere
		try {
			ord = args[0];
			filnavn = args[1];
			antTraader = Integer.parseInt(args[2]);
			if (antTraader < 1) {
				throw new Exception();
			}
			minBariere = new CountDownLatch(antTraader);

		} catch (Exception e) {
			System.out.println("Feil parametere: ord, filnavn, antTraader");
			System.exit(0);
		}

		//Leser fil og legger i array
		lesFil();

		//Starter tråder
		if (antTraader == 1) {
			int teller = 0;
			for (String s : ordliste) {
				if (s.equals(ord)) {
					teller++;
				}
			}
			monitor.settAntall(teller);
			minBariere.countDown();
		} else {
			System.out.println("Starter tråder");
			for (int i = 0; i < antTraader; i++) {
				//opprett tråd
				Thread traaden = new Thread(new FinnAntall().new TelleTraad((i+1)));
				traaden.start();
			}
		}

		//Vent og les fra monitor
		try {
			System.out.println("Venter på tråder å fullføre.");
			minBariere.await();
		} catch (InterruptedException e) {
			System.out.println("minBariere interrupted");
		}
		System.out.println("Alle tråder er ferdige.");
		System.out.println("Antall forekomster: " + monitor.hentAntall() );
	}

	/**
	 * Leser inn ord fra fil, oppretter og lagrer i array
	 */
	public static void lesFil() {
		Scanner les = null;
		boolean ferdig = false;

		//Finner fil
		while (!ferdig) {
			try {
				File fil = new File(filnavn);
				les = new Scanner(fil);
				ferdig = true;
			} catch (FileNotFoundException e) {
				System.out.println("Kunne ikke finne fil.");
			}
		}

		//Antall ord i lista
		if (les.hasNextLine()) {
			try {
				antOrd = Integer.parseInt(les.nextLine()) -1;
			} catch (NumberFormatException e) {
				System.out.println("Kunne ikke lese første linje i filen riktig.");
				System.exit(0);
			}
		}

		//Opprett ordliste
		ordliste = new String[antOrd+2];

		//Les resten av ordene
		int teller = 0;
		while (les.hasNextLine()){
			ordliste[teller++] = les.nextLine();
		}

		//Splitt i forskjellige ordlister
		int nrDeltOpp = 0;
		int antPrArray = antOrd/antTraader;
		System.out.println("Antall ord pr. tråd: " + antPrArray);

		for (int i = 0; i < antTraader; i++) {
			String [] nyDel = new String[antPrArray];
			System.arraycopy(ordliste, nrDeltOpp, nyDel, 0, antPrArray);
			nrDeltOpp = nrDeltOpp + antPrArray;

			listeDeler.add(nyDel);
		}
	}
}