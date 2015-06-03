/**
* Grensesnitt for utlaan av boker
* 
* @author mariusch
* @version 09.02.15
*/

public class HylleTest {
	public static void main(String[] args) {

		//Oppretter test hylle
		Hylle<Bok> hylle = new Hylle<>(100);

		//Test 1 - Setter inn på tom
		System.out.println("***  TEST 1  *** - Sett in paa tom");
		test("Sjekker settInn() på ledig plass.", true, hylle.settInn(56, new Bok()));

		//Test 2 - Prøver å sette inn på opptatt
		System.out.println("***  TEST 2  *** - Sett in paa opptatt");
		test("Sjekker settInn() på opptatt plass.", false, hylle.settInn(56, new Bok()));

		//Test3 - Sjekk at plass er ledig etter fjernet bok
		System.out.println("***  TEST 3  *** - Plass er ledig etter fjernet bok");
		hylle.taUt(56);
		test("Sjekker om tom etter aa ha tatt ut.", true, hylle.ledig(56));

		//Test4 - Setter inn etter at tatt ut
		System.out.println("***  TEST 4  *** - Setter inn etter at tatt ut");
		test("Sjekker settInn() etter aa ha tatt ut.", true, hylle.settInn(56, new Bok()));
		
		//Test5 - Prøver å sette inn på ugyldig plasser
		System.out.println("***  TEST 5  *** - Sette inn på ugyldig plasser");
		test("Sjekker om plass over array er ugyldig (100).", false, hylle.settInn(100, new Bok()));
		test("Sjekker om plass under array er ugyldig (-1).", false, hylle.settInn(-1, new Bok()));
	}

	/**
	 * Testmetode for aa gjore tester
	 * @param  beskrivelse beskriver hva som blir testet
	 * @param  forventet    forventet verdi
	 * @param  faktiskVerdi      faktisk verdi som testes
	 */
	public static <T> void test(String beskrivelse, T forventet, T faktiskVerdi) {
		if (forventet != null && forventet.equals(faktiskVerdi)) {
			System.out.printf("OK - %s%n", beskrivelse);
		} else if (forventet == faktiskVerdi) {
			System.out.printf("OK - %s%n", beskrivelse);
		} else {
			System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
				beskrivelse,
				forventet,
				faktiskVerdi);
		}
	}
}