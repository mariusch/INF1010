/**
* Klasse for TestProgram
*
* SØNDAG 22. MARS:
* Nytt lagt inn søndag 22. mars 2015 (linje 487 - 625) + nye tillegg i klassene Lege, Resept og Person
* Har testet og regnet ut at virkestoff, antall gyldige resepter osv fungerer og gir riktige tall
* Mangler nå å gjøre programmet mer robust - typ try/catch for alt av feil inntasting :)
* Vi snakkes!
*
*  Supert, bra jobba!
* - Fikset så Valg 5 i statestikk ikke skriver ut informasjon om Personer med bare utgåtte resepter (reit = 0).
* 
*  	      ** Implementerte metoder  ***
*  		      ✔  	1: Les fil
*      	      ✔ 	2: Skriv fil
*         	  ✔  	3: Skriv ut alt
*             ✔ 	4: Nytt legemiddel
*             ✔  	5: Ny lege
*             ✔ 	6: Ny person
*             ✔		7: Ny resept
*             ✔ 	8: Hent legemiddel på resept
*             ✔ 	9: Statistikk
*	
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

import java.io.*;
import java.util.*;

public class Meny {

	static SortertEnkelListe<Lege> alleLegerListe = new SortertEnkelListe<>();
	static EnkelReseptListe alleResepterListe = new EnkelReseptListe();
	static Tabell<Person> allePersonerListe = new Tabell<>(100);
	static Tabell<Legemiddel> alleLegemidlerListe = new Tabell<>(100);

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		boolean programSlutt = false;

		while (!programSlutt) {
			System.out.println("");
			System.out.println("                            ***  MENY  ***   ");
			System.out.println("1)Les fra fil       2)Skriv til fil       3)Skriv ut alt       4)Nytt legemiddel\n5)Ny lege           6)Ny person           7)Ny resept          8)Hent legemiddel\n9)Statistikk        0)Avslutt");
			System.out.print("Valg: ");
			String valg = sc.nextLine();

			switch (valg) {
	                  case "1": //Les fra fil
	                  lesFil();
	                  break;

	                  case "2": //Skriv til fil
	                  skrivFil();
	                  break;

	                  case "3": //Skriv ut alt
	                  skrivUtAlt();
	                  break;

	                  case "4": //Ny Nytt legemiddel
	                  nyttLegemiddel();
	                  break;

	                  case "5": //Ny lege
	                  nyLege();
	                  break;

	                  case "6": //Ny person
	                  nyPerson();
	                  break;

	                  case "7": //Ny resept
	                  nyResept();
	                  break;

	                  case "8": //Hent legemiddel på resept
	                  hentLegemiddel();
	                  break;

	                  case "9": //Statistikk
	                  lagStatistikk();
	                  break;

	                  case "0": //Avslutt
	                  programSlutt = true;
	                  break;

	                  default:
	                  System.out.println("Ugyldig valg. Prov paa nytt.");
	                  break;
	            }
     	 }
	}

	 //Menymetoder
	public static void lesFil() throws Exception{
		Scanner les = null;
		Scanner skriv = new Scanner(System.in);
		boolean ferdig = false;

		while (!ferdig) {
			System.out.print("Skriv inn navn på fil: ");
			try {
				File fil = new File(skriv.nextLine());
				les = new Scanner(fil);
				ferdig = true;
			} catch (FileNotFoundException e) {
				System.out.println("Kunne ikke finne fil.");
			}
		}

		while (les.hasNextLine()){
			String linje = les.nextLine();

			if (linje.contains("Personer")){
				linje = les.nextLine();
				while (! (linje.equals(""))){
					String[] param = linje.split(", ");
					String navn = param[1];
					String personNr = param[2];
					String adresse = param[3];
					String postNr = param[4];
					opprettPerson(navn, personNr, adresse, postNr);
					linje = les.nextLine();
				}
			}
			else if (linje.contains("Legemidler")){
				linje = les.nextLine();

				while (! (linje.equals(""))){
					String[] param = linje.split(", ");
					String navn = param[1];
					String form = param[2];
					String type = param[3];

					double pris = Double.parseDouble(param[4]);
					int mengde = Integer.parseInt(param[5]);
					double virkestoff = Double.parseDouble(param[6]);

					if (form.equals("pille")){
						if (type.equals("a")){
							int styrke = Integer.parseInt(param[7]);
							opprettPilleTypeA(navn, pris, mengde, virkestoff, styrke);
						}
						else if (type.equals("b")){
							int styrke = Integer.parseInt(param[7]);
							opprettPilleTypeB(navn, pris, mengde, virkestoff, styrke);
						}
						else if (type.equals("c")){
							opprettPilleTypeC(navn, pris, mengde, virkestoff);
						}

					}
					else if (form.equals("mikstur")){
						if (type.equals("a")){
							int styrke = Integer.parseInt(param[7]);
							opprettMiksturTypeA(navn, pris, mengde, virkestoff, styrke);
						}
						else if (type.equals("b")){
							int styrke = Integer.parseInt(param[7]);
							opprettMiksturTypeB(navn, pris, mengde, virkestoff, styrke);
						}
						else if (type.equals("c")){
							opprettMiksturTypeC(navn, pris, mengde, virkestoff);            				
						}

					}
					linje = les.nextLine();
				}
			}
			else if (linje.contains("Leger")){
				linje = les.nextLine();

				while (! (linje.equals("")) ){
					String[] param = linje.split(", ");
					String navn = param[0];
					int avtaleNummer = Integer.parseInt(param[1]);

					if (avtaleNummer == 0){
						opprettLege(navn);
					}
					else{
						opprettFastLege(navn, avtaleNummer);
					}
					linje = les.nextLine();
				}
			} 
			else if (linje.contains("Resepter")){

				linje = les.nextLine();
				while (! (linje.equals(""))){
					String[] param = linje.split(", "); 
					String type = param[1];
					int persId = Integer.parseInt(param[2]);
					String legeNavn = param[3];
					int legemiddelNr = Integer.parseInt(param[4]);
					int reit = Integer.parseInt(param[5]);

					Legemiddel legemiddel = alleLegemidlerListe.finn(legemiddelNr);
					Lege lege = alleLegerListe.finn(legeNavn);
					double pris = legemiddel.getPris();

					if (type.equals("blå")){
						opprettBlaaResept(legemiddel, lege, persId, reit);
					}
					else if (type.equals("hvit")){
						opprettHvitResept(legemiddel, lege, persId, reit, pris);
					}
					linje = les.nextLine();
				}
			}
		}
		System.out.print("Leste inn data fra fil. [Enter]");
		sc.nextLine();

	}

	public static void skrivFil() {
		PrintWriter pw = null;
		boolean ferdig = false;

		while (!ferdig) {
			String filnavn = lesInnTekst("Skriv inn filnavn: ");
			try {
				File fil = new File(filnavn);
				pw = new PrintWriter(fil);
				ferdig = true;
			} catch (Exception e){
				System.out.println("Kunne ikke skrive til valgt fil");
			}
		}

		//Person
		pw.println("# Personer (nr, navn, fnr, adresse, postnr)");
		for (Person p : allePersonerListe) {
			pw.println(p.skrivFil());
		}
		pw.println("");

		//Legemidler
		pw.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])");
		for (Legemiddel l : alleLegemidlerListe) {
			if (l instanceof PilleTypeA) {

				PilleTypeA p = (PilleTypeA) l;
				pw.println(p.skrivFil());
			} else if (l instanceof PilleTypeB) {

				PilleTypeB p = (PilleTypeB) l;
				pw.println(p.skrivFil());
			} else if (l instanceof PilleTypeC) {

				PilleTypeC p = (PilleTypeC) l;
				pw.println(p.skrivFil());
			} else if (l instanceof MiksturTypeA) {

				MiksturTypeA p = (MiksturTypeA) l;
				pw.println(p.skrivFil());
			} else if (l instanceof MiksturTypeB) {

				MiksturTypeB p = (MiksturTypeB) l;
				pw.println(p.skrivFil());
			} else if (l instanceof MiksturTypeC) {

				MiksturTypeC p = (MiksturTypeC) l;
				pw.println(p.skrivFil());
			}
		}
		pw.println("");

		//Leger
		pw.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
		for (Lege l : alleLegerListe) {
			pw.println(l.skrivFil());
		}
		pw.println("");

		//Resepter
		pw.println("# Resepter (nr, hvit/blå, persNummer, legeNavn, legemiddelNummer, reit)");
		for (Resept r : alleResepterListe) {
			pw.println(r.skrivFil());
		}
		pw.println("");

		//Slutt
		pw.println("# Slutt");
		pw.close();
		System.out.print("Skrev data til fil. [Enter]");
		sc.nextLine();
	}

	public static void skrivUtAlt() {
		System.out.println("");
	      //Skrive ut alle personer, alle leger (sortert pa navn), aller legemidler og alle resepter.
		System.out.println("***  Personer  ***");
		for (Person p : allePersonerListe) {
			System.out.println(p);
		}

		System.out.println("");
		System.out.println("***  Leger  ***");
		for (Lege l : alleLegerListe) {
			System.out.println(l);
		}

		System.out.println("");
		System.out.println("***  Legemidler  ***");
		for (Legemiddel l : alleLegemidlerListe) {
			System.out.println(l);
		}

		System.out.println("");
		System.out.println("***  Resepter  ***");
		for (Resept r : alleResepterListe) {
			System.out.println(r);
		}
		sc.nextLine();
	}

	public static void nyttLegemiddel() {

		String navn = lesInnTekst("Navn på legemiddel: ");
		double pris = lesInnDesimalTall("Pris: ");
		int antall = lesInnTall("Mengde/antall: ");
		double virkestoff = lesInnDesimalTall("Virkestoff: ");

		String form = lesInnTekst("Hvilken form er det? (Pille / Mikstur) ");

		if (form.equalsIgnoreCase("pille")) {
			String type = lesInnTekst("Hvilken type er det? (A, B, C) ");

			if (type.equalsIgnoreCase("a")) {
				int narkotiskVerdi = lesInnTall("Narkotisk verdi: ");
				opprettPilleTypeA(navn, pris, antall, virkestoff, narkotiskVerdi);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else if (type.equalsIgnoreCase("b")) {
				int vanedannendeVerdi = lesInnTall("Narkotisk verdi: ");
				opprettPilleTypeB(navn, pris, antall, virkestoff, vanedannendeVerdi);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else if (type.equalsIgnoreCase("c")){
				opprettPilleTypeC(navn, pris, antall, virkestoff);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else {
				System.out.println("Ugyldig valg.");
			}

		} else if (form.equalsIgnoreCase("mikstur")) {
			String type = lesInnTekst("Hvilken type er det? (A, B, C) ");

			if (type.equalsIgnoreCase("a")) {
				int narkotiskVerdi = lesInnTall("Narkotisk verdi: ");
				opprettMiksturTypeA(navn, pris, antall, virkestoff, narkotiskVerdi);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else if (type.equalsIgnoreCase("b")) {
				int vanedannendeVerdi = lesInnTall("Narkotisk verdi: ");
				opprettMiksturTypeB(navn, pris, antall, virkestoff, vanedannendeVerdi);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else if (type.equalsIgnoreCase("c")){
				opprettMiksturTypeC(navn, pris, antall, virkestoff);
				System.out.print("Legemiddelet " + navn + " ble opprettet. [Enter]");
				sc.nextLine();

			} else {
				System.out.println("Ugyldig valg.");
			}

		} else {
			System.out.println("Ugyldig valg.");
		}
	}

	public static void nyLege() {
		String navn = lesInnTekst("Navn på lege: ");
		int avtaleNr = lesInnTall("Avtalenummer (0 hvis ikke fastlege): ");

		if (avtaleNr != 0) {
			opprettFastLege(navn, avtaleNr);
			System.out.print("Fastlegen " + navn + " ble opprettet. [Enter]");
			sc.nextLine();

		} else {
			opprettLege(navn);
			System.out.print("Legen " + navn + " ble opprettet. [Enter]");
			sc.nextLine();
		}
	}

	public static void nyPerson() {
		String navn = lesInnTekst("Navn på person: ");
		String personNr = lesInnTekst("Fødselsnummer: ");
		String adresse = lesInnTekst("Adresse: ");
		String postNr = lesInnTall("Postnummer: ") + "";

		opprettPerson(navn, personNr, adresse, postNr);
		System.out.print("Personen " + navn + " ble opprettet. [Enter]");
		sc.nextLine();
	}

	public static void nyResept() {
		System.out.println("Legemidler: ");
		
		for (Legemiddel l : alleLegemidlerListe){
			System.out.println(l.getProdNr() + " " + l.getNavn());
		}

		System.out.println(" ");
		int prodNr = lesInnTall("Skriv ID-nummer på valgt legemiddel: ");
		String legeNavn = lesInnTekst("Navn på legen: ");
		int persId = lesInnTall("Personlig ID: ");
		int reit = lesInnTall("Reit: ");
		String type = lesInnTekst("Hva slags type resept (hvit/blaa): ");

		Legemiddel legemiddel = alleLegemidlerListe.finn(prodNr);
		if (legemiddel == null) {
			System.out.println("Fant ikke legemiddel");
		} else {
				Lege lege = alleLegerListe.finn(legeNavn);
			if (lege == null) {
				System.out.println("Fant ikke lege");
			} else {
				if (type.equalsIgnoreCase("hvit")){
					if (allePersonerListe.finn(persId) == null) {
						System.out.print("Fant ikke oppgitt person. [Enter]");
						sc.nextLine();
					} else {
						opprettHvitResept(legemiddel, lege, persId, reit, legemiddel.getPris());
						System.out.print("Resepten ble opprettet. [Enter]");
						sc.nextLine();
					}
				}else if (type.equalsIgnoreCase("blaa")){
					if (allePersonerListe.finn(persId) == null) {
						System.out.print("Fant ikke oppgitt person. [Enter]");
						sc.nextLine();
					} else {
						opprettBlaaResept(legemiddel, lege, persId, reit);
						System.out.print("Resepten ble opprettet. [Enter]");
						sc.nextLine();
					}
				}
				else{
					System.out.println("Ugyldig valg.");
				}
			}
		}
		
	}

	public static void hentLegemiddel() {
		int persNr = lesInnTall("Tast inn personlig ID-nummer: ");
		Person p = allePersonerListe.finn(persNr);
		if (p == null) {
			System.out.println("Kunne ikke finne oppgitt person.");
		} else {

			System.out.println("Resepter: ");
			for (Resept r : p.getReseptListe()){
				System.out.println(r);
			}
			
			int resNr = lesInnTall("Tast inn ID-nummer på ønsket resept: ");
			Resept res = p.getReseptListe().finn(resNr);
			if (res == null) {
				System.out.println("Kunne ikke finne oppgitt resept.");
			} else {
				Legemiddel lm = res.getLegemiddel();

				if (lm == null) {
					System.out.println("Kunne ikke finnen oppgitt legemiddel.");
				} else {
					if (p.getReseptListe().hentUt(resNr)){
						System.out.println(" ");
						System.out.println("** KVITTERING **");
						System.out.println("Lege: " + res.getLege().getNavn()); //Legenavn
						System.out.println("Utskrevet til: " + p); //Person
						System.out.println(" ");
						lm.skrivUtKvittering(res);
						System.out.println("Resterende reit: " + res.getReit() + "       [ ENTER ]");
						sc.nextLine();
					}		
					else{
						System.out.println("Resepten er ugyldig (reit = 0)");
					}
				}
			}
		}
	}

	public static void lagStatistikk() {

	boolean statSlutt = false;

		while (!statSlutt) {
			System.out.println(" ");
			System.out.println("1) Vis antall resepter på vanedannende legemidler");
			System.out.println("2) Hent en persons blå resepter");
			System.out.println("3) Vis en leges resepter på mikstur-preparater og total mengde virkestoff i utskrevne resepter");
			System.out.println("4) Vis leger som har skrevet ut resepter på Type A legemidler");
			System.out.println("5) Vis personer med minst én gyldig resept på Type A legemiddel");
			System.out.println("0) Avlsutt statistikk");
			System.out.println(" ");
			System.out.print("Valg: ");
			String valg = sc.nextLine();

			switch (valg) {
	                  case "1": //Vis oversikt over vanedannende midler
	                  visVaneDannende();
	                  break;

	                  case "2": //Hent persons blå resepter
	                  hentBlaaResepter();
	                  break;

	                  case "3": //Vis leges mikstur-resepter og virkestoff
	                  legeMiksturOgVirkestoff();
	                  break;

	                  case "4": //Vis leges A-resepter
	                  legeAResepter();
	                  break;

	                  case "5": //Vis persons gyldige A-resepter
	                  persAResepter();
	                  break;

	                  case "0": //Avslutt
	                  statSlutt = true;
	                  break;

	                  default:
	                  System.out.println("Ugyldig valg. Prov paa nytt.");
	                  break;
	            }
     	 }
    }



//1. Totalt antall vanedannende resepter og hvor mange som er skrevet ut til personer bosatt i Oslo.

	public static void visVaneDannende(){
		int totAntVane = 0;
		int totOslo = 0;
		for (Resept r : alleResepterListe) {
			if (r.getLegemiddel() instanceof PilleTypeB || r.getLegemiddel() instanceof MiksturTypeB) {
				totAntVane++;
				Person p = allePersonerListe.finn(r.getPersId());
				if (p.iOslo()){
					totOslo++;
				}
			}
		}
		System.out.println("Det finnes totalt " + totAntVane + " resepter på vanedannende legemidler.");
		System.out.println("Av disse er " + totOslo + " skrevet ut til personer i Oslo.");
		System.out.print("[Enter]");
		sc.nextLine();
	}
		


//- 2. For en gitt person, skriv ut alle dens blå resepter, yngste resept først. Personen identifiseres enten ved sitt fødselsnummer eller ved dets unike nummer i programmet.

	public static void hentBlaaResepter(){
		int idNr = lesInnTall("Tast inn persons idNr: ");
		Person p = allePersonerListe.finn(idNr);

		if (p == null) {
			System.out.println("Kunne ikke finne oppgitt person. [Enter]");
			sc.nextLine();
		} else {
			for (Resept res : p.getReseptListe()){
				if (res instanceof BlaaResept){
					System.out.println(res);
				}
			}
			System.out.print("[Enter]");
			sc.nextLine();
		}
	}



//- 3. For en lege med et gitt navn, skriv ut alle legens resepter på mikstur-preparater, eldste resept først. Skriv også ut den samlede mengde virkestoff for alle resepter legen har skrevet ut, og hvor mye av dette som er i pilleform og hvor mye er mikstur.
	
	public static void legeMiksturOgVirkestoff(){
		String navn = lesInnTekst("Navn på lege: ");
		Lege lege = alleLegerListe.finn(navn);

		if (lege == null) {
			System.out.println("Kunne ikke finne oppgitt lege. [Enter]");
			sc.nextLine();
		} else {
			//Utskrift av mikstur-preparater
			for (Resept res : lege.getReseptListe()){
				if (res.getLegemiddel() instanceof Mikstur){
					System.out.println(res);
				}
			}
			double vsPille = lege.getVirkestoffPille();
			double vsMikstur = lege.getVirkestoffMikstur();
			double vsTotal = vsPille + vsMikstur;
			//Total mengde virkestoff i navn sine utskrevne resepter: (virkestoffPille + virkestoffMikstur) + "mg. (Pille: virkestoffPille / Mikstur: virkestoffMisktur)" );
			System.out.println("Total mengde virkestoff i " + navn + " sine utskrevne resepter: " + vsTotal + "mg. (Pille: " + vsPille + " / Mikstur: " + vsMikstur + ")");
			System.out.print("[Enter]");
			sc.nextLine();
		}
	}	



// - 4. Skriv ut leger (i alfabetisk rekkefølge) som har opprettet minst en (gyldig eller ikke) resept på TypeA-legemiddel, og antallet slike resepter per lege.	

	public static void legeAResepter(){	

		System.out.println("****** Leger som har skrevet ut typeA-resepter ******");
		for (Lege lege : alleLegerListe){
			if (lege.getTypeA() > 0){
				System.out.println(lege + ", Type A-resept: " + lege.getTypeA() + " stk");
			}
		}
		System.out.print("[Enter]");
		sc.nextLine();
	}


// - 5. List opp navnene på alle personer som har minst en gyldig resept på narkotiske legemidler, og for disse, skriv ut antallet per person.
		
	public static void persAResepter(){
		System.out.println("****** Personer med gyldige typeA-resepter ******");
		
		int antGyldigTypeA = 0;
		for (Person pers : allePersonerListe) {
			
			for (Resept res : pers.getReseptListe()) {
				
				if (res.getLegemiddel() instanceof PilleTypeA || res.getLegemiddel() instanceof MiksturTypeA) {
			
					if(res.getReit() > 0){
						antGyldigTypeA++;
					}
				}
			}
			if (antGyldigTypeA > 0) {
				System.out.println(pers + ", TypeA-resept: " + antGyldigTypeA + " stk");
			}
			antGyldigTypeA = 0;
		}
		System.out.print("[Enter]");
		sc.nextLine();
	}

	//Opprettmetoder
	@SuppressWarnings("unchecked")
	public static void opprettLege(String navn) {
		Lege lege = new Lege(navn);
		alleLegerListe.settInn(lege);
	}

	@SuppressWarnings("unchecked")
	public static void opprettFastLege(String navn, int avtaleNummer) {
		Fastlege fLege = new Fastlege(navn, avtaleNummer);
		alleLegerListe.settInn(fLege);
	}

	public static void opprettPerson(String navn, String personNr, String adresse, String postNr) {

		Person p = new Person(navn, personNr, adresse, postNr);
		allePersonerListe.settInn(p.getIdNr(), p);

	}

	public static void opprettHvitResept(Legemiddel legemiddel, Lege lege, int persId, int reit, double pris) {
		HvitResept r = new HvitResept(legemiddel, lege, persId, reit, pris);

			//Legg til i: EnkelReseptListe - Hovedliste over alle resepter FIFO
		alleResepterListe.settInn(r);
			//Legg til i: YngsteForstReseptListe - Hver person sin egen reseptliste LIFO
		Person p = allePersonerListe.finn(persId);
		p.getReseptListe().settInn(r);
			//Legg til i: EldsteForstReseptListe - Hver person sin egen reseptliste FIFO
		Lege l = alleLegerListe.finn(lege.getNavn());
		l.getReseptListe().settInn(r);

	}

	public static void opprettBlaaResept(Legemiddel legemiddel, Lege lege, int persId, int reit) {
		BlaaResept r = new BlaaResept(legemiddel, lege, persId, reit);

			//Legg til i: EnkelReseptListe - Hovedliste over alle resepter FIFO
		alleResepterListe.settInn(r);
			//Legg til i: YngsteForstReseptListe - Hver person sin egen reseptliste LIFO
		Person p = allePersonerListe.finn(persId);
		p.getReseptListe().settInn(r);
			//Legg til i: EldsteForstReseptListe - Hver person sin egen reseptliste FIFO
		Lege l = alleLegerListe.finn(lege.getNavn());
		l.getReseptListe().settInn(r);

	}

	public static void opprettPilleTypeA(String navn, double pris, int antall, double virkestoff, int narkotiskVerdi) {
		PilleTypeA l = new PilleTypeA(navn, pris, antall, virkestoff, narkotiskVerdi);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	public static void opprettPilleTypeB(String navn, double pris, int antall, double virkestoff, int vanedannendeVerdi) {
		PilleTypeB l = new PilleTypeB(navn, pris, antall, virkestoff, vanedannendeVerdi);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	public static void opprettPilleTypeC(String navn, double pris, int antall, double virkestoff) {
		PilleTypeC l = new PilleTypeC(navn, pris, antall, virkestoff);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	public static void opprettMiksturTypeA(String navn, double pris, int antall, double virkestoff, int narkotiskVerdi) {
		MiksturTypeA l = new MiksturTypeA(navn, pris, antall, virkestoff, narkotiskVerdi);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	public static void opprettMiksturTypeB(String navn, double pris, int antall, double virkestoff, int vanedannendeVerdi) {
		MiksturTypeB l = new MiksturTypeB(navn, pris, antall, virkestoff, vanedannendeVerdi);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	public static void opprettMiksturTypeC(String navn, double pris, int antall, double virkestoff) {
		MiksturTypeC l = new MiksturTypeC(navn, pris, antall, virkestoff);
		alleLegemidlerListe.settInn(l.getProdNr(), l);

	}

	//Input metoder
	private static String lesInnTekst(String beskrivelse) {
		boolean ferdig = false;
		String tekst = null;
		while (!ferdig) {
			System.out.print(beskrivelse);
			try {
				tekst = sc.nextLine();
				if (tekst.equals("")) {
					throw new Exception();
				}
				return tekst;
			} catch (Exception e) {
				System.out.println("Feil med inntasting, prøv på nytt.");
			}

		}
		return tekst;
	}

	private static int lesInnTall(String beskrivelse) {
		boolean ferdig = false;
		int tall = 0;
		while (!ferdig) {
			System.out.print(beskrivelse);
			try {
				String tekst = sc.nextLine();
				if (tekst.equals("")) {
					throw new Exception();
				}
				tall = Integer.parseInt(tekst);
				return tall;
			} catch (Exception e) {
				System.out.println("Feil med inntasting, prøv på nytt.");
			}

		}
		return tall;
	}

	private static double lesInnDesimalTall(String beskrivelse) {
		boolean ferdig = false;
		double tall = 0;
		while (!ferdig) {
			System.out.print(beskrivelse);
			try {
				String tekst = sc.nextLine();
				if (tekst.equals("")) {
					throw new Exception();
				}
				tall = Double.parseDouble(tekst);
				return tall;
			} catch (Exception e) {
				System.out.println("Feil med inntasting, prøv på nytt.");
			}

		}
		return tall;
	}
}