/**
 * Obligatorisk oppgave 9,10,11
 * INF1010 - V15
 * Universitetet i Oslo
 *
 *
 * @author mariusch
 * @version 11.05.15
 */

public class Brett {

	private Rute[][] brett;

	public Brett(Rute[][] brett) {
		this.brett = brett;
	}

	public Rute[][] getRuteBrett() {
		return brett;
	}

	public void angreVerdier(Rute r) {
		if (r != null) {
			if (r instanceof TomRute) {
				r.settVerdi(0);
			}

			this.angreVerdier(r.neste);
		}
	}

}