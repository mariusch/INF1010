public class Losning {

	private Rute[][] losningBrett;

	public Losning(Rute[][] brett) {
		int strl = brett.length;
		Rute[][] losning = new Rute[strl][strl];

		for(int i=0; i<brett.length; i++) {
			for(int j=0; j<brett[i].length; j++) {
				Rute rute = brett[i][j];
				Rute losningRute;
				if (brett[i][j] instanceof TomRute) {
					losningRute = new TomRute(rute.getVerdi(), brett.length, null);
				} else {
					losningRute = new FastRute(rute.getVerdi(), brett.length, null);
				}
		    	losning[i][j]=losningRute;
		   }
		}
		this.losningBrett = losning;
	}

	@Override
	public String toString() {
		return "";
	}

	public void skrivUt() {
		for (int i = 0; i < losningBrett.length; i++) {

		    Rute[] sub = losningBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
				System.out.print(verdi + " ");
		    }
		    System.out.println();
		}
	}

	public Rute[][] getLosning() {
		return losningBrett;
	}

}