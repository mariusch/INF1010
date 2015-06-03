import java.util.*;
import java.io.*;

public class Oblig4Main {

	/**
	 * Henter forskjellige typer Bil relaterte objekter fra fil og oppretter de
	 * @param  args      filen som leses inn
	 * @throws Exception kaster expetions
	 */
	public static void main(String[] args) throws Exception{
		ArrayList<Bil> biler = new ArrayList<>();

		File fil = new File(args[0]);

		Scanner innFil = new Scanner(fil);

		while (innFil.hasNextLine()) {
			String linje = innFil.nextLine();

			String sjekk1 = "el";
			String sjekk2 = "bil";
			String sjekk3 = "fossil";
			String sjekk4 = "lastebil";
			String sjekk5 = "personfossilbil";

			//ElBil
			if (linje.toLowerCase().contains(sjekk1.toLowerCase()) ) {
				biler.add( lagreElBil(linje) );
			} 
			//Lastebil
			else if ( linje.toLowerCase().contains(sjekk4.toLowerCase()) ) { 
				biler.add( lagreLasteBil(linje) );
			}
			//Personfossilbil
			else if ( linje.toLowerCase().contains(sjekk5.toLowerCase()) ) { 
				biler.add( lagrePersonFossilBil(linje) );
			}
			//Fossil
			else if ( linje.toLowerCase().contains(sjekk3.toLowerCase()) ) { 
				biler.add( lagreFossilBil(linje) );
			}
			//Bil
			else { 
				biler.add( lagreBil(linje) );
			}        
		}

		//Skriver ut
		for (Bil b : biler) {
		    if (b instanceof PersonBil) {
		    	PersonBil p = (PersonBil) b;
		        System.out.println("Personbil: " + p.bilNr + "    Utslipp: " + p.utslipp + "    Plasser: " + p.passasjerer);
		    }
		}
	}

	/**
	 * Metode for å lagre data i objekt for ElBil
	 * @param  linje data som skal lagres
	 * @return       PersonBil objekt
	 */
	public static ElBil lagreElBil(String linje) {
		ElBil b = new ElBil();
		//Nummerskilt
		b.bilNr = linje.substring(4,9);
		//kW
		b.kW = Integer.parseInt(linje.substring(10));

		return b;
	}

	/**
	 * Metode for å lagre data i objekt for Bil
	 * @param  linje data som skal lagres
	 * @return       PersonBil objekt
	 */
	public static Bil lagreBil(String linje) {
		Bil b = new Bil();
		//Nummerskilt
		b.bilNr = linje.substring(4);

		return b;
	}

	/**
	 * Metode for å lagre data i objekt for FossilBil
	 * @param  linje data som skal lagres
	 * @return       PersonBil objekt
	 */
	public static FossilBil lagreFossilBil(String linje) {
		FossilBil b = new FossilBil();
		//Nummerskilt
		b.bilNr = linje.substring(4,10);
		//Utslipp
		b.utslipp = Double.parseDouble( linje.substring(15,20) );

		return b;
	}

	/**
	 * Metode for å lagre data i objekt for LasteBil
	 * @param  linje data som skal lagres
	 * @return       PersonBil objekt
	 */
	public static LasteBil lagreLasteBil(String linje) {
		LasteBil b = new LasteBil();

		//Nummerskilt
		b.bilNr = linje.substring(9,16);
		//Utslipp
		b.utslipp = Double.parseDouble( linje.substring(17,22));
		//Nyttevekt
		b.nyttevekt = Double.parseDouble(linje.substring(23));

		return b;
	}

	/**
	 * Metode for å lagre data i objekt for PersonBil
	 * @param  linje data som skal lagres
	 * @return       PersonBil objekt
	 */
	public static PersonBil lagrePersonFossilBil(String linje) {
		PersonBil b = new PersonBil();
		//Nummerskilt
		b.bilNr = linje.substring(16,23);
		//Utslipp
		b.utslipp = Double.parseDouble( linje.substring(24,29));
		//Passasjerer
		b.passasjerer = Integer.parseInt(linje.substring(30,31));

		return b;
	}
}