/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

import javax.swing.*;
import java.io.*;
import java.util.*;

class Sudoku extends SwingWorker {
	protected int RADER;
	protected int KOLONNER;
	private final int MANGE;
    private long tidBrukt;
    private boolean ferdig;

	private Brett brett;
	private Boks[] bokser;
	private Rad[] rader;
	private Kolonne[] kolonner;
	private SudokuBeholder losningBeholder;

	public Sudoku() {
		losningBeholder = new SudokuBeholder();
		MANGE = 5;
        ferdig = false;
	}

    @Override
    protected Object doInBackground() throws Exception {
        start();
        return null;
    }

    @Override
    protected void done() {
        this.skrivTilSkjerm();
        System.out.println("SwingWorker er ferdig.");
        firePropertyChange("ferdig", 0, 1);
    }


    public void start() {
		System.out.println("Startet sudoku løser!");
		Rute[][] r = brett.getRuteBrett();
		long start = System.currentTimeMillis();    
		r[0][0].fyllUtDenneRuteOgResten();
        tidBrukt = System.currentTimeMillis() - start;

		System.out.println("Fant " + losningBeholder.hentAntallLosninger() + " antall løsning(er) på " + tidBrukt + "ms.");
        this.ferdig = true;
	}

    public long getTid() {
        return tidBrukt;
    }

    public SudokuBeholder getBeholder() {
        return losningBeholder;
    }

	/**
	 * Opprett en og en rute med verdi
	 * Lagre så hver rute i brettet
	 */
	public void lesFil(String filnavn) {

		//Finne fil
		File fil = new File(filnavn);
		Scanner les = null;
		try {
			les = new Scanner(fil);
		} catch (FileNotFoundException e) {
			System.out.println("Kunne ikke finne fil.");
		}

		//Lese info
		RADER = Integer.parseInt( les.nextLine() );
		KOLONNER = Integer.parseInt( les.nextLine() );
		int storrelse = RADER * KOLONNER;

		//BrettArray
		Rute[][] ruteBrett = new Rute[storrelse][storrelse];

		//Lese brett
		int tellerRad = 0;
		int tellerKol = 0;
		try {
			while (les.hasNextLine()) {
				String linje = les.nextLine();

				for (int i = 0; i < linje.length(); i++) {
					if (linje.charAt(i) == '.') {
						//System.out.println(linje.charAt(i));
						TomRute rute = new TomRute(0, RADER*KOLONNER, this);
						ruteBrett[tellerRad][tellerKol] = rute;
					} else {
						//System.out.println(linje.charAt(i));
						FastRute rute = new FastRute(Character.getNumericValue(linje.charAt(i)), RADER*KOLONNER, this);
						ruteBrett[tellerRad][tellerKol] = rute;
					}
					tellerKol++;
				}
				tellerKol = 0;
				tellerRad++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ugyldig filformat.");
			System.exit(0);
		}

		//Opprett Brett
		brett = new Brett(ruteBrett);

		//Sett neste pekere og brett i Rute
		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	if (j+1 != sub.length) {

		    		sub[j].settNeste(sub[j+1]);

		    	} else if (i+1 != ruteBrett.length) {
		    		sub[j].settNeste(ruteBrett[i+1][0]);
		    	}
		    }
		}

		//Del inn ruter i felt
		delInnRuter();

	}


	public void skrivTilFil(String filnavn) {
		PrintWriter pw = null;
		boolean ferdig = false;

		while (!ferdig) {
			try {
				File fil = new File(filnavn);
				pw = new PrintWriter(fil);
				ferdig = true;
			} catch (Exception e){
				System.out.println("Kunne ikke skrive til valgt fil");
			}
		}

		ArrayList<Losning> losninger = losningBeholder.getLosninger();

		int teller = 0;
		for (Losning losning : losninger) {

			Rute[][] brett = losning.getLosning();

			//Hvis få løsninger
			if (losninger.size() < MANGE) {
				pw.println("Løsning " + (++teller));
				for (int i = 0; i < brett.length; i++) {

				    Rute[] sub = brett[i];
				    for (int j = 0; j < sub.length; j++) {
				    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
			    		pw.print(verdi);
				    }
				    pw.println();
				}
			}
			//Hvis mange løsninger
			else {
				pw.print((++teller) + ": ");
				for (int i = 0; i < brett.length; i++) {

				    Rute[] sub = brett[i];
				    for (int j = 0; j < sub.length; j++) {
				    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
			    		pw.print(verdi);
				    }
				    pw.print("//");
				}
				pw.println();
			}
			
		}

		pw.close();
	}

	public void skrivTilSkjerm() {
		ArrayList<Losning> losninger = losningBeholder.getLosninger();

		for (Losning losning : losninger) {
			losning.skrivUt();
		}

	}

	public void lagreBrett(Rute[][] brett) {
		Losning losning = new Losning(brett);

		losningBeholder.settInn(losning);
	}

	/**
	 * Skriv ut spillbrettet fra to-dim-array
	 */
	public void skrivUtBrett() {
		Rute[][] ruteBrett = brett.getRuteBrett();

		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
				System.out.print(verdi + " ");
		    }
		    System.out.println();
		}
	}

	/**
	 * Skriv ut spillbrettet fra to-dim-array
	 */
	public void skrivUtBrett(Rute[][] ruteBrett) {
		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
				System.out.print(verdi + " ");
		    }
		    System.out.println();
		}
	}

	//Brukt for debugging
	public void skrivUtDetaljert() {
		Rute[][] ruteBrett = brett.getRuteBrett();

		System.out.println("\nNeste pekre i Rute:");
		ruteBrett[0][0].skrivUtDenneOgNeste();

		System.out.print("\n \n");
		System.out.println("R: Rad. K: Kolonne. B: Boks. M: Mulige. V: Verdi");

		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Rute r = sub[j];
				System.out.print("R:" + r.getRad() + "K:" + r.getKolonne() + "B:" + r.getBoks() + "M:" + r.finnAlleMuligeTall().toString() + "V:" + Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "  ");
		    }
		    System.out.println();
		}
	}

    public int getN() {
        return RADER*KOLONNER;
    }

	//Kalles på etter lesFil
	public void delInnRuter() {
		bokser = new Boks[RADER*KOLONNER];
		rader = new Rad[RADER*KOLONNER];
		kolonner = new Kolonne[RADER*KOLONNER];

		Rute[][] ruteBrett = brett.getRuteBrett();

		//Rader
		for (int i = 0; i < ruteBrett.length; i++) {
			Rad rad = new Rad(i+1, brett);
			rader[i] = rad;

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Rute rute = sub[j];
				rute.settRad(rad);
				rad.settRute(rute);
		    }
		}
		
		//Kolonner
		for (int i = 0; i < kolonner.length; i++) {
			Kolonne k = new Kolonne(i+1, brett);
			kolonner[i] = k;
		}

		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Rute rute = sub[j];
		    	Kolonne kolonne = kolonner[j];
		    	rute.settKolonne(kolonne);
		    	kolonne.settRute(rute);
		    }
		}

		//Bokser
		for (int i = 0; i < bokser.length; i++) {
			Boks b = new Boks(i+1, brett);
			bokser[i] = b;
		}

		int kolTeller= 0;
		int radTeller= 0;
		int boksTeller= 0;
		int teller = 0;

		for (int i = 0; i < ruteBrett.length; i++) {
			if (teller == RADER) {
	    		teller=0;
	    		radTeller = radTeller + RADER;
	    	}

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	
		    	if (kolTeller == KOLONNER) {
		    		boksTeller++;
		    		kolTeller = 0;
		    	}
		    	Rute rute = sub[j];
		    	Boks boks = bokser[(boksTeller + radTeller)];
		    	rute.settBoks(boks);
		    	boks.settRute(rute);
		    	kolTeller++;
		    }
		    boksTeller = 0;
		    kolTeller = 0;
		    teller++;
		}

	}

    public boolean ferdig() {
        return this.ferdig;
    }
}