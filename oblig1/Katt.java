/**
* Klassestruktur for Katt objekter
* 
*
* @author mariusch
* @version 28.01.15
*/

public class Katt {

	private String navn;
	private int vekt;
	private int antMus;
	private boolean sykdomsstatus;

	/**
	 * Konstruktør for å opprette katt objekter
	 * @param  navn          navnet på katten
	 * @param  vekt          vekten til katten
	 * @param  sykdomsstatus sykdomsstatusen til katten
	 */
	public Katt(String navn, int vekt, boolean sykdomsstatus) {

		this.navn = navn;
		this.vekt = vekt;
		this.sykdomsstatus = sykdomsstatus;
		this.antMus = 0;
	}

	/**
	 * Konstruktør for å opprette katt objekter
	 * @param  navn navnet på katten
	 */
	public Katt(String navn) {
		this.navn = navn;
		this.vekt = 5000;
		sykdomsstatus = false;
		this.antMus = 0;
	}

	/**
	 * get metode for navn
	 * @return navnet på katten
	 */
	public String navn() {
		return navn;
	}

	/**
	 * Get metode for vekt
	 * @return vekten på katten
	 */
	public int vekt(){
		return vekt;
	}

	/**
	 * Get metode for sykdomsstatus
	 * @return true hvis syk
	 */
	public boolean syk() {
		if (!sykdomsstatus) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Get metode for mus i magen
	 * @return antall mus i magen
	 */
	public int antMus() {
		return antMus;
	}

	/**
	 * Hjelpemetode til {@link #gaaPaaJaktI()}
	 * @param bytte museobjektet som spises
	 */
	private void spis(Mus bytte) {

		if (bytte.syk()) {
			sykdomsstatus = true;
		}

		bytte.bliSpist();

		int nyVekt = vekt + bytte.vekt();
		vekt = nyVekt;

		antMus = antMus + 1;
	}

	/**
	 * Mus gaar paa jakt i musebol
	 * @param musebolet Musebolet det jaktes i
	 *
	 * Ingen katter spiser døde mus.
	 * Katter med 2 mus i magen er mette og vil ikke spise, men fortsatt bite mus.
	 * En katt som spiser ei syk mus, blir selv syk.
	 * Dersom en katt spiser en mus vil kattens vekt øke tilsvarende musens vekt i gram.
	 * Denne metoden skal ikke sette musen tilbake i bolet sitt, men bruke bolets grensesnitt for å få tilgang til musen som bor der.
	 * Mus som er syke og bites dør
	 * 
	 */
	public Mus gaaPaaJaktI(Bol<Mus> musebolet) {
		Mus mus = musebolet.beboer();

		if (antMus == 2) {
			if (mus.lever() && mus.syk()) {
				mus.bit();
				mus.bliSpist();
				mus = null;
			} else if (mus.lever()) {
				mus.bit();
			}
		} else if (mus.lever()) {
			spis(mus);
			mus = null;
		}
		return mus;
	}

}