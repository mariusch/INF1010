/**
* Klassestruktur for Mus objekter
* 
*
* @author mariusch
* @version 28.01.15
*/

public class Mus {

	private boolean sykdomsstatus = false;
	private int vekt = 0;
	private boolean lever = true;
	private static int museteller = 1;
	private String navn;

	/**
	 * Konstruktør for å opprette mus
	 * @param  vekt vekten til musen i int
	 * @param  syk  true hvis musen er syk
	 */
	public Mus(int vekt, boolean syk) {
		this.vekt = vekt;
		this.sykdomsstatus = syk;
		navn = "musNr" + museteller;
		museteller++;
	}

	/**
	 * Get metode for sykdom
	 * @return true hvis syk
	 */
	public boolean syk() {
		return sykdomsstatus;
	}

	/**
	 * Get metode for vekt
	 * @return vekt i gram
	 */
	public int vekt() {
		return vekt;
	}

	/**
	 * Get metode for om levende
	 * @return true hvis levende
	 */
	public boolean lever() {
		return lever;
	}

	/**
	 * Musen blir syk
	 */
	public void bit() {
		sykdomsstatus = true;
	}

	/**
	 * Musen blir sist og dør
	 */
	public void bliSpist(){
		lever = false;
	}

	/**
	 * Skriver ut tilstand om musen
	 * @param testid navnet på testen
	 */
	public void infoOmTilstand(String testid) {
		System.out.println("--- " + testid + "  --- Info om mus: navn: " + navn + " vekt: " + vekt + " syk: " + sykdomsstatus + " lever: " + lever);
	}

	/**
	 * Sjekker om musens tilstand er lik som parameterene
	 * @param testid navn på testen, sjekket ikke
	 * @param navn   navnet på musen
	 * @param syk    true hvis musen er syk
	 * @param vekt   vekten til musen
	 * @param lever  true hvis musen lever
	 */
	public void sjekktilstand(String testid, String navn, boolean syk, int vekt, boolean lever) {
		System.out.println("********* Test av musobjekt, testid: " + testid + " ***");
		//Navn
		System.out.print("** navn: " + navn + ",");
		if (navn.equals(this.navn)){
			System.out.print(" OK.\n");
		} else {
			System.out.print(" FEIL. Er:" + navn + " skulle vaert: " + this.navn + "\n");
		}
		//Syk
		System.out.print("** syk: " + sykdomsstatus + ",");
		if (syk == this.sykdomsstatus) {
			System.out.print(" OK.\n");
		} else {
			System.out.print(" FEIL.\n");
		}
		//Vekt
		System.out.print("** vekt: " + vekt + ",");
		if (vekt == this.vekt) {
			System.out.print(" OK.\n");
		} else {
			System.out.print(" FEIL.\n");
		}
	}

}