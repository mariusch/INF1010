class ikkeLever{
	public static void main(String[] args) {
		
		int høyde=2;
		int bredde=3;
		int føyde=0;
		int fbredde=0;
		int i=6;
		boolean ferdig=false;
		int[][] test = new int[i][i];

		for(int x=0; x<i; x++){
			for(int y=0; y<i; y++){
				test[x][y]=0;
			}
		}
		int teller=0;
		int bokser=0;
		while(!ferdig){
			for(int x=0; x<(bredde+=fbredde); x++){
				for(int y=0; y<høyde; y++){
					test[y][x]=bokser;
					teller++;
				}System.out.println("");
			}bokser++;
			fbredde=bredde;
		}
			for(int x=0; x<i; x++){
				for(int y=0; y<i; y++){
					System.out.print(test[x][y]+ " ");
				}System.out.println("");
			}
	}
}