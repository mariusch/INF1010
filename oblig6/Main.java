/**
* Klasse for TestProgram
* 
*   ** TO DO ***
*		- Eventuelt gjøre utfordringsoppgaver
*			- Felles Iterator for EnkelReseptListe og SortertEnkelListe
*			- Opprett større array hvis full i Tabell
* 
* @author mariusch
* @author ingersda
* @version 16.03.15
*/

public class Main {

	static SortertEnkelListe<Lege> alleLegerListe = new SortertEnkelListe<>();
	static EnkelReseptListe alleResepterListe = new EnkelReseptListe();
	static Tabell<Person> allePersonerListe = new Tabell<>(100);
	static Tabell<Legemiddel> alleLegemidlerListe = new Tabell<>(100);

	public static void main(String[] args) {

		/* **** LEGER I SORTERTENKELLISTE ***** */
		System.out.println("\n**** LEGER I SORTERTENKELLISTE *****");
		opprettLege("Hansen");
		opprettLege("Knutsen");
		opprettLege("Gundersen");
		opprettLege("Eriksen");
		opprettLege("Qvale");
		opprettLege("Vold");
		opprettLege("Helner");
		opprettLege("Vixen");
		opprettLege("Bark");
		opprettLege("Aasmundseth");
		opprettLege("Zahl");
		opprettLege("Haug");
		opprettLege("Iversen");
		opprettLege("Arnulfsen");
		opprettLege("Barsk");
		opprettLege("Zorro");
		opprettLege("Hole");
		opprettFastLege("Bjarnulfsen (Fastlege)", 12345678);
		opprettLege("Christiansen");
		opprettLege("Arnulfsen");

		for (Lege l : alleLegerListe) {
			System.out.println(l);
		}

		/* **** PERSONER OG TABELL<PERSON> ***** */
		//Virker!!
		System.out.println("\n**** PERSONER I TABELL<PERSON> *****");
		opprettPerson("Arne", "1234", "VeiersVei 11", "0565");
		opprettPerson("Bjarne", "1234", "VeierasVei 11", "0565");
		opprettPerson("Carl", "1234", "VeiersVei 11", "0565");
		opprettPerson("David", "1234", "VeierasVei 11", "0565");

		for (Person p : allePersonerListe) {
			System.out.println(p);
		}




		/* **** LEGEMIDLER OG TABELL<LEGEMIDDEL> ***** */
		//Virker!!
		System.out.println("\n**** LEGEMIDLER I TABELL<LEGEMIDDEL> *****");
		opprettPilleTypeA("Pille A", 100.00, 10, 73.20, 7);
		opprettPilleTypeB("Pille B", 120.00, 10, 73.20, 8);
		opprettPilleTypeC("Pille C", 99.50, 10, 6.4);
		opprettMiksturTypeA("Mikstur A", 100.00, 10, 7.4, 9);
		opprettMiksturTypeB("Mikstur B", 120.00, 10, 73.20, 8);
		opprettMiksturTypeC("Mikstur C", 99.50, 10, 6.4);

		for (Legemiddel l : alleLegemidlerListe) {
			System.out.println(l);
		}



		Lege lege = alleLegerListe.finn("Eriksen");


		/* **** RESEPTER OG ENKELRESEPTLISTE ***** */
		System.out.println("\n**** RESEPTER I ENKELRESEPTLISTE *****");
		opprettHvitResept(new PilleTypeC("Pille", 130, 10, 10.0),  lege, 0, 3, 119.50);
		opprettBlaaResept(new PilleTypeC("Pille", 130, 10, 10.0),  lege, 0, 3);
		opprettHvitResept(new MiksturTypeB("Mikstur", 133.3, 10, 10.0, 9),  lege, 0, 3, 119.50);
		opprettBlaaResept(new MiksturTypeC("Mikstur", 13.4, 20, 10.0),  lege, 0, 3);


		for (Resept r : alleResepterListe) {
			System.out.println(r);
		}




		/* **** LEGES RESEPTLISTE ***** */
		System.out.println("\n**** LEGERS RESEPTLISTE *****");
		for (Resept r : lege.getReseptListe()){
			System.out.println(r);
		}


		/* **** PERSONS RESEPTLISTE ***** */
		System.out.println("\n**** PERSONS RESEPTLISTE *****");

		Person pers = allePersonerListe.finn(0);
		 for (Resept r : pers.getReseptListe()){
		 	System.out.println(r);
		 }

	}

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

	//Piller
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

	//Mikstur
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

}