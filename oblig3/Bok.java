/**
* Grensesnitt for utlaan av boker
* 
* @author mariusch
* @version 09.02.15
*/

public class Bok implements TilUtlaan{
	private String laaner;

	/**
	 * Laaner ut en gitt bok, hvis ledig
	 * @param  navn navn paa laaner
	 * @return      ture hvis suksess
	 */
	public boolean laan(String navn) {
		if (laaner == null) {
			this.laaner = navn;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returnerer boken og setter laaner til null
	 */
	public void retur() {
		this.laaner = null;
	}

	/**
	 * Tester bokklassen for feil
	 * @param  args argumenter
	 */
	public static void main(String[] args) {
		//Oppretter test bok
		Bok bok1 = new Bok();

		//Tester om den kan utlaanes riktig
		//Test 1
		if (bok1.laan("Jens")) {
			System.out.println("1: OK: Boken kan laanes ut, om ledig.");
		} else {
			System.out.println("1: FEIL: Boken kan ikke laanes ut, om ledig.");
		}
		//Test 2
		if (!bok1.laan("Per")) {
			System.out.println("2: OK: Boken kan ikke laanes ut, naar opptatt.");
		} else {
			System.out.println("2: FEIL: Boken kan laanes ut naar opptatt.");
		}

		//Sjekker om ledig for laan etter retur
		//Test3
		bok1.retur();
		if (bok1.laan("Jens")) {
			System.out.println("3: OK: Boken kan laanes ut, om ledig etter retur.");
		} else {
			System.out.println("3: FEIL: Boken kan ikke laanes ut etter retur.");
		}

	}
}