import java.util.Scanner;
import java.io.*;
class Brett {
	Rute[][] brett;
	String fil;
	int antRader;
	int antKolonner;
	String[] tegnIRad;
	Rad[] rader;
	String lFil;
	Kolonne[] kolonner;
	Boks[] bokser;
	final int n;

	Brett(int xx, int yy, String fil, String lFil){
		this.fil=fil;
		antRader=xx;
		antKolonner=yy;
		n=xx*yy;
		this.lFil=lFil;
		brett=new Rute[n][n];
		lesFil();
		printBrett();
		delInnRuter(antRader, antKolonner, n);
		finnMulige();
		//testNeste();
		 
	}

	public void lesFil(){
		try{
			Rute forrige=null;
			Scanner lesFil=new Scanner(new File(fil));
			//hopper over de 2 første linjene
			lesFil.nextLine();
			lesFil.nextLine();
			while(lesFil.hasNextLine()){
				tegnIRad=new String[n];
				//looper langs en rad.
				for(int x=0; x<n; x++){					
					//henter alle tegn på en linje
					String rad=lesFil.nextLine();
					for(int l = 0; l < n; l++){
						tegnIRad[l]=rad.substring(l,(l+1));
					}
					//looper nedover en kolonne
					for(int y=0; y<n; y++){
						if(tegnIRad[y].equals(".")){
							Rute r = new Rute(0, false, n, this);
							if(forrige!=null){
								forrige.settNeste(r);
							}
							brett[x][y]=r;
							forrige=r;

						}
						else{
							Rute r = new Rute(Integer.parseInt(tegnIRad[y]), true, n, this);
							if(forrige!=null){
								forrige.settNeste(r);
							}
							brett[x][y]=r;
							forrige=r;
						}
					}
				}
			}//while er ferdig
		}
		catch(Exception e){
			System.out.println("ting gikk galt med lesing av fil!");
		}
	}
	public void printBrett(){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				Rute skrivUt=brett[i][j];
				if(false){
					System.out.print(". ");
				}
				else{
					System.out.print(skrivUt+" ");
				}
			}
			System.out.println("");
		}
	}
	public void delInnRuter(int antRader, int antKolonner, int n){
		rader=new Rad[n];
		kolonner=new Kolonne[n];
		bokser=new Boks[n];
		for(int r=0; r<n; r++){
			Rad ra=new Rad(n, r);
			rader[r]=ra;
			Kolonne ko = new Kolonne(n, r);
			kolonner[r]=ko;
			Boks bo=new Boks(n, r);
			bokser[r]=bo;
		}
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				brett[x][y].settRad(rader[x]);
				brett[x][y].settKolonne(kolonner[y]);
			}
		}
		boolean ferdig=false;
		int riktigVerdi=0;
		int antBokserIBredden=(n/antKolonner);
		
		int fkolonne=0;	
		int teller=0;
		int tmpStartY=0;
		int tmpStartx=0;
		int tmpSluttx=antRader;

		while(!ferdig){	
			for(int x=tmpStartx; x<tmpSluttx; x++){
				for(int y=tmpStartY; y<(antKolonner+fkolonne); y++){
					brett[x][y].settBoks(bokser[riktigVerdi]);
					
				}
				
			}riktigVerdi++;
			teller++;
			if(riktigVerdi==n){
				ferdig=true;
			}
			
			if(teller==antBokserIBredden){
				teller=0;
				tmpStartx+=antRader;
				tmpSluttx+=antRader;
				tmpStartY=0;
				fkolonne=0;
			}

			else if(fkolonne<n){
				
				fkolonne+=antKolonner;
				tmpStartY+=antKolonner;
			}
			else{
				ferdig=true;
			}
		}
		//testing:
		System.out.println("TESTER BOKSER:");
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				System.out.print(brett[x][y].getBoks().getId()+" ");
			}
			System.out.println("");
		}

		System.out.println("TESTER RADER:");
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				System.out.print(brett[x][y].getRad().getId()+" ");
			}
			System.out.println("");
		}
		System.out.println("TESTER KOLONNER:");
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				System.out.print(brett[x][y].getKolonne().getId()+" ");
			}
			System.out.println("");
		}
	}
	public void finnMulige(){
		
	
		//looper brettet og finner alle faste verdier og legger disse inn i sine rader/kolonner/bokser
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				if(brett[x][y].getVerdi()!=0){
					rader[x].settOpptatt(brett[x][y].getVerdi());
					kolonner[y].settOpptatt(brett[x][y].getVerdi());
					brett[x][y].getBoks().settOpptatt(brett[x][y].getVerdi());
				}
			}
		}
		//printMulige();
	}
	public void printMulige(){
		int [] mulige = new int[n];
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				
				mulige=brett[x][y].finnAlleMuligeTall();
				if(mulige==null){
					System.out.println("plass "+ x + "," + y + " har allerede ett tall: " + brett[x][y].getVerdi());

				}
				else{
					System.out.println("Mulige tall for plass: " + x + "," + y + " : ");
					for(int i = 0; i<n; i++){
						
						if(mulige[i]!=0){
							System.out.println(mulige[i]);
						}
					}
				}
			}System.out.println("\n");
		}

	}
	public void testNeste(){
		Rute neste=brett[0][0];
		while(neste!=null){
			System.out.println(neste.getId());
			neste=neste.neste;
		}
	}
	public Rute faaForste(){
		return brett[0][0];
	}
}