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