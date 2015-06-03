
public class Oblig2TestC {

    public static void main(String[] args) {
	
		/* Denne testen bruker beholdere av typen String[] for aa holde paa feilmeldinger som legges til naar programmet oppdager en feil returverdi.
		Feilmeldinger printes bare om de eksisterer. Om det ikke er noen feilmeldinger vil programmet ikke printe ut annet enn antall feil som vil vaere 0.
		Testen er tredelt: I hver del lages et nytt mengdeobjekt. I foerste del sjekkes i hovedsak leggTil(), i andre del sjekkes fjern-metodene og
		i tredje del sjekkes det om programmet fungerer med en Mengde av klassen Object. Tom() og inneholder() sjekkes fortloepende gjennom alle delene. */

        /* Lager beholdere for feilmeldinger med plass til 10 feilmeldinger i hver */
        String[] feilmeldingerTom = new String[10];
        String[] feilmeldingerLeggTil = new String[10];
        String[] feilmeldingerFjernEldste = new String[10];
        String[] feilmeldingerFjernNyeste = new String[10];
        String[] feilmeldingerInneholder = new String[10];
        
		/* Initialiserer tellere for hvert array og for antall feil */
		int fmTomCnt = 0, fmLeggTilCnt = 0, fmFjernEldsteCnt = 0, fmFjernNyesteCnt = 0, fmInneholderCnt = 0;
        int antallFeil = 0;

        /* Tester metodene leggTil() og tom() og inneholder() ved aa legge inn objekter og sjekke returverdiene til hver av metodene */
        Mengde<String> stringMengde = new Mengde<String>();
        if (!stringMengde.tom()) {
            feilmeldingerTom[fmTomCnt++] = ("Feil i metode tom():    returnerer feil: returnerer false naar lista er tom");
            antallFeil++;
        }
        String test1 = new String("Test 1");
        if (!stringMengde.leggTil(test1)) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer false naar man legger til foerste objekt (Test 1)");
            antallFeil++;
        }
        if (!stringMengde.inneholder(test1)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer false naar objektet (Test 1) skal vaere i lista");
            antallFeil++;
        }
        if (!stringMengde.leggTil("Test 2")) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer false naar man legger til andre objekt (Test 2)");
            antallFeil++;
        }
		String test3 = new String("Test 3");
        if (!stringMengde.leggTil(test3)) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer false naar man legger til tredje objekt (Test 3)");
            antallFeil++;
        }
        if (stringMengde.leggTil(test3)) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer true naar man legger til tredje objekt (Test 3) for andre gang og objektet skal alt eksistere i lista");
            antallFeil++;
        }
        if (stringMengde.leggTil(test1)) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer true naar man legger til foerse objekt (Test 1) for andre gang og objektet skal alt eksistere i lista");
            antallFeil++;
        }
        if (stringMengde.tom()) {
            feilmeldingerTom[fmTomCnt++] = ("Feil i metode tom():    returnerer feil: returnerer true naar lista ikke er tom");
            antallFeil++;
        }

        /* Tester metodene fjernEldste() og fjernNyeste() */
        Mengde<String> stringMengde1 = new Mengde<String>();
        stringMengde1.leggTil("Test 4");
        stringMengde1.leggTil("Test 5");
        stringMengde1.leggTil("Test 6");

        String test4 = stringMengde1.fjernEldste();
        if (test4 == null) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    returnerer feil: returnerer null naar det finnes en eldste: skulle returnert fjerde objekt (Test 4");
            antallFeil++;
        } else if (!test4.equals("Test 4")) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    feil verdi: returnerer feil objekt: skulle returnert fjerde objekt (Test 4)");
            antallFeil++;
        }
        if (stringMengde1.inneholder(test4)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer true naar objektet (Test 4) skal vaere slettet fra lista");
            antallFeil++;
        }

        String test5 = stringMengde1.fjernEldste();
        if (test5 == null) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    returnerer feil: returnerer null naar det finnes en eldste: skulle returnert femte objekt (Test 5)");
            antallFeil++;
        } else if (!test5.equals("Test 5")) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    feil verdi: returnerer feil objekt: skulle returnert femte objekt (Test 5)");
            antallFeil++;
        }
        if (stringMengde1.inneholder(test5)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer true naar objektet (Test 5) skal vaere slettet fra lista");
            antallFeil++;
        }

        stringMengde1.leggTil("Test 7");
        stringMengde1.leggTil("Test 8");

        String test8 = stringMengde1.fjernNyeste();

        if (test8 == null) {
            feilmeldingerFjernNyeste[fmFjernNyesteCnt++] = ("Feil i metode fjernNyeste():    returnerer feil: returnerer null naar det finnes en nyeste: skulle returnert aattende objekt (Test 8)");
            antallFeil++;
        } else if (!test8.equals("Test 8")) {
            feilmeldingerFjernNyeste[fmFjernNyesteCnt++] = ("Feil i metode fjernNyeste():    feil verdi: returnerer feil objekt: skulle returnert aattende objekt (Test 8");
            antallFeil++;
        }
        if (stringMengde1.inneholder(test8)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer true naar objektet (Test 8) skal vaere slettet fra lista");
            antallFeil++;
        }

        String test7 = stringMengde1.fjernNyeste();
        if (test7 == null) {
            feilmeldingerFjernNyeste[fmFjernNyesteCnt++] = ("Feil i metode fjernNyeste():    returnerer feil: returnerer null naar det finnes en nyeste: skulle returnert syvende objekt (Test 7)");
            antallFeil++;
        } else if (!test7.equals("Test 7")) {
            feilmeldingerFjernNyeste[fmFjernNyesteCnt++] = ("Feil i metode fjernNyeste():    feil verdi: returnerer feil objekt: skulle returnert syvende objekt (Test 7)");
            antallFeil++;
        }

        String test6 = stringMengde1.fjernEldste();
        if (test6 == null) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    returnerer feil: returnerer null naar det finnes en eldste: skulle returnert sjette objekt (Test 6)");
            antallFeil++;
        } else if (!test6.equals("Test 6")) {
            feilmeldingerFjernEldste[fmFjernEldsteCnt++] = ("Feil i metode fjernEldste():    feil verdi: returnerer feil objekt: skulle returnert sjette objekt (Test 6)");
            antallFeil++;
        }
        if (!stringMengde1.tom()) {
            feilmeldingerTom[fmTomCnt++] = ("Feil i metode tom():    returnerer feil: returnerer false naar lista skal ha blitt tom etter aa ha testet fjernEldste() og fjernNyeste()");
            antallFeil++;
        }

        /* Tester metoden inneholder() paa objekter istedet for String for aa teste at dette fungerer*/
        Mengde<Object> objectMengde = new Mengde<Object>();
        Object test9 = new Object();
        Object test10 = new Object();
        if(!objectMengde.leggTil(test9)) {
            feilmeldingerLeggTil[fmLeggTilCnt++] = ("Feil i metode leggTil():    returnerer feil: returnerer false naar man legger til et nytt objekt (Test 9)");
            antallFeil++;
        }
        if (objectMengde.inneholder(test10)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer true naar objekt (Test 10) ikke finnes i lista");
            antallFeil++;
        }
        objectMengde.leggTil(test10);
        if (!objectMengde.inneholder(test9)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer false naar man tester for et objekt (Test 9) som skal ha vaert lagt til tidligere");
            antallFeil++;
        }
        if (!objectMengde.inneholder(test10)) {
            feilmeldingerInneholder[fmInneholderCnt++] = ("Feil i metode inneholder():    returnerer feil: returnerer false naar man tester for et objekt (Test 10) som skal ha vaert lagt til tidligere");
            antallFeil++;
        }

        /* Skriver ut feilmeldinger
		Det skrives bare ut feilmeldinger i de tilfellene de eksisterer */

        /* Feilmeldinger for metoden tom() */
        if (fmTomCnt != 0) {
            System.out.println("---------------- * FEILMELDINGER FOR METODE: tom() * ----------------");
            for (String s : feilmeldingerTom) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        /* Feilmeldinger for metoden leggTil() */
        if (fmLeggTilCnt != 0) {
            System.out.println("---------------- * FEILMELDINGER FOR METODE: leggTil() * ----------------");
            for (String s : feilmeldingerLeggTil) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        /* Feilmeldinger for metoden fjernEldste() */
        if (fmFjernEldsteCnt != 0) {
            System.out.println("---------------- * FEILMELDINGER FOR METODE: fjernEldste() * ----------------");
            for (String s : feilmeldingerFjernEldste) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        /* Feilmeldinger for metoden fjernNyeste() */
        if (fmFjernNyesteCnt != 0) {
            System.out.println("---------------- * FEILMELDINGER FOR METODE: fjernNyeste() * ----------------");
            for (String s : feilmeldingerFjernNyeste) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        /* Feilmeldinger for metoden fjern() */
        if (fmInneholderCnt != 0) {
            System.out.println("---------------- * FEILMELDINGER FOR METODE: inneholder() * ----------------");
            for (String s : feilmeldingerInneholder) {
                if (s != null) {
                    System.out.println(s);
                }
            }
        }

        /* Antall feilmeldinger */
        System.out.println();
        System.out.println("ANTALL FEIL: " + antallFeil);
    }
}
