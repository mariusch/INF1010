class Oblig2Test {

	/*
	Denne klassen skal du ikke trenge aa endre paa, den er bare til hjelp
	for deg og for retterne(men lever den sammen med resten).

	Konsentrer deg om en test om gangen og ikke vent til du er helt ferdig med
	aa bruke testene. Lykke til!
	*/
	public static void main(String[] args) {
		Mengde<String> tomMengde = new Mengde<>();
		test("tom() paa tom mengde returnerer true", true, tomMengde.tom());
		//      beskrivelse          forventet returverdi, det vi tester

		Mengde<String> litenMengde = new Mengde<>();
		litenMengde.leggTil("Hei");
		test("tom() paa ikke-tom mengde returnerer false", false, litenMengde.tom());

		Mengde<Integer> tallMengde = new Mengde<>();
		Integer en = 1;
		test("inneholder() paa en tom mengde skal returnere false", false, tallMengde.inneholder(en));
		test("leggTil() med et nytt element skal returnere true", true, tallMengde.leggTil(en));
		tallMengde.leggTil(2);
		Integer tre = 3;
		tallMengde.leggTil(tre);
		tallMengde.leggTil(4);
		Integer fem = 5;
		tallMengde.leggTil(fem);
		test("inneholder() skal returnere false for elementer som ikke er i mengden", false, tallMengde.inneholder(100));
		test("inneholder() skal klare aa finne eldste element", true, tallMengde.inneholder(en));
		test("inneholder() skal klare aa finne et element midt i mengden", true, tallMengde.inneholder(tre));
		test("inneholder() skal klare aa finne nyeste element", true, tallMengde.inneholder(fem));
		test("leggTil() med et eksisterende element skal returnere false", false, tallMengde.leggTil(tre));

		test("fjernEldste() paa en tom mengde skal returnere null", null, tomMengde.fjernEldste());

		Mengde<Boolean> boolMengde = new Mengde<>();
		boolMengde.leggTil(true);
		boolMengde.fjernEldste();
		test("fjernEldste() paa en mengde med ett element skal gi en tom mengde", true, boolMengde.tom());

		Mengde<String> halloMengde = new Mengde<>();
		String hallo = "Hallo";
		halloMengde.leggTil(hallo);
		halloMengde.leggTil("Hei");
		halloMengde.leggTil("Tjolahopp!");
		test("fjernEldste() skal returnere det forste objektet vi la inn", hallo, halloMengde.fjernEldste());

		test("fjernNyeste() paa en tom mengde skal returnere null", null, tomMengde.fjernNyeste());

		Mengde<Boolean> boolMengde2 = new Mengde<>();
		boolMengde2.leggTil(true);
		boolMengde2.fjernNyeste();
		test("fjernNyeste() paa en mengde med ett element skal gi en tom mengde", true, boolMengde2.tom());

		Mengde<String> heiMengde = new Mengde<>();
		String hei = "Hei";
		heiMengde.leggTil("Hallo");
		heiMengde.leggTil("Tjolahopp!");
		heiMengde.leggTil(hei);
		test("fjernNyeste() skal returnere det siste objektet vi la inn", hei, heiMengde.fjernNyeste());
	}

	/*
	Frivillig lesning:

	Metoden test() under er generisk. Generiske metoder fungerer veldig likt
	generiske klasser. Man bare setter f.eks. <T> foran returtypen, og
	man kan saa bruke T som en type i metoden.

	Her sier vi bare at argumentene expected og actual kan vaere hvilken type
	som helst saa lenge de er samme type.

	Naar man kaller en generisk metode trenger man ikke tenke paa at den er
	generisk. Man trenger ikke lage generiske metoder selv i INF1010, men man
	kan hvis man vil (og de kan til tider spare deg mye kode).

	For mer om generiske metoder:
	http://docs.oracle.com/javase/tutorial/extra/generics/methods.html
	*/
	public static <T> void test(String description, T expected, T actual) {
		if (expected != null && expected.equals(actual)) {
			System.out.printf("OK - %s%n", description);
		} else if (expected == actual) {
			System.out.printf("OK - %s%n", description);
		} else {
			System.out.printf("FEIL - %s. Skulle vaert: %s. Var: %s%n",
				description,
				expected,
				actual);
		}
	}
}