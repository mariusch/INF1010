class Rute{
	static int lopNr;
	static boolean ferdig;
	static boolean back;
	int verdi;
	int id;
	boolean fastTall;
	Rute neste;
	Rad ra;
	Kolonne ko;
	Boks bo;
	int [] alleMuligeTall;
	int antmulige;
	Brett b;

	Rute(int verdi, boolean fTall, int antmulige, Brett b){
		this.b = b;
		this.verdi=verdi;
		fastTall=fTall;
		alleMuligeTall=new int[antmulige];
		this.antmulige=antmulige;
		id=lopNr++;
	}

	public String toString() {
		return verdi + "";
	}

	public int getVerdi(){
		return verdi;
	}
	public void settRad(Rad ra){
		this.ra=ra;
	}
	public Rad getRad(){
		return ra;
	}
	public void settKolonne(Kolonne ko){
		this.ko=ko;
	}
	public Kolonne getKolonne(){
		return ko;
	}
	public void settBoks(Boks bo){
		this.bo=bo;
	}
	public Boks getBoks(){
		return bo;
	}
	public void settNeste(Rute b){
		neste=b;
	}
	public int getId(){
		return id;
	}

 
	public int[] finnAlleMuligeTall(){
		if(verdi!=0){
			return null;
		}
		//holder for å finne alle mulige
		boolean[] alleMulige=new boolean[antmulige];
		for(int i=0; i<antmulige; i++){
			//gjør alle tall mulige
			alleMulige[i]=true;
		}
		//holder for talle man ikke kan bruke
		boolean[] radOpptatt=new boolean[antmulige];
		boolean[] kolonneOpptatt=new boolean[antmulige];
		boolean[] boksOpptatt=new boolean[antmulige];
		//fyller holderne med riktig array
		radOpptatt=ra.getMulige();
		kolonneOpptatt=ko.getMulige();
		boksOpptatt=bo.getMulige();
		//fjerner alle tall som ikke kan brukes fra alleMulige[]
		for(int i=0; i<antmulige; i++){
			if(radOpptatt[i]==false){
				alleMulige[i]=false;
			}
			if(kolonneOpptatt[i]==false){
				alleMulige[i]=false;
			}
			if(boksOpptatt[i]==false){
				alleMulige[i]=false;
			}
		}
		int index=0;
		for(int i=0; i<antmulige; i++){
			if(alleMulige[i]==true){
				alleMuligeTall[index]=(i+1);
				index++;
			}

		}
		return alleMuligeTall;
	}
	public void settLedig(int i){
		ra.settLedig(i);
		ko.settLedig(i);
		bo.settLedig(i);
	}
	public void settOpptatt(int i){
		ra.settOpptatt(i);
		ko.settOpptatt(i);
		bo.settOpptatt(i);
	}
	public void settVerdi(int i){
		if(verdi!=0){
			System.out.println("gjør plasser ledig!!! (" + id + ", " + verdi + ")");
			settLedig(verdi);
		}
		verdi=i;
		if(verdi==0){
			return;
		}
		if(verdi!=0){
			settOpptatt(verdi);
		}
	}
	public void fyllUtDenneRutenOgResten(){
		//sjekker om tallet skal endres
		if(fastTall){	
			if(back==true){
				return;
			}
			if(neste!=null){
				neste.fyllUtDenneRutenOgResten();
				if(ferdig==true){
					System.out.println("Dette er brettet:");
					b.printBrett();
					return;
				}
			}
			//sjekker om det er det siste tallet
			if(neste==null){
				System.out.println("NESTE===null");
				System.out.println("Dette er brettet:");
						b.printBrett();
				ferdig=true;
				return;
			}
		} 
		else{
			int muligeTall[]=new int[antmulige];
			muligeTall=finnAlleMuligeTall();
			//printer mulige tall
			System.out.println("Mulige tall for rute " + id);
			for(int i =0; i <antmulige; i++){
				System.out.println(muligeTall[i]);
			}
			for(int i =0; i <=antmulige; i++){
				//prøver første tall
				if(muligeTall[i]!=0){
					settVerdi(muligeTall[i]);
					back=false;
					System.out.println("Rute " + id + " fikk verdi " + muligeTall[i]);
					if(neste==null){
						System.out.println("NESTE=null");
						System.out.println("Dette er brettet:");
						b.printBrett();
						ferdig=true;
						return;
					}
					System.out.println("Går til neste rute: " + neste.getId());
					neste.fyllUtDenneRutenOgResten();
					if(ferdig==true){
						System.out.println("Dette er brettet:");
						b.printBrett();
						return;
					}
				}
				else{
					System.out.println("ingen ledige tall");
					back=true;
					settVerdi(0);
					return;
				}
			}
		}
	}
}