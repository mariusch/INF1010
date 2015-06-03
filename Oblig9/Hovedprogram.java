import java.util.Scanner;
import java.io.*;

class Hovedprogram{
		
		public static void main(String[] args)throws Exception{
			String fil = args[0];
			String lFil="IKKE BRUK";
			try{
				if(args[1]!=null){
					lFil=args[1];
				}
			}
			catch(Exception e){
				
			}
			Scanner lesFil = new Scanner(new File(fil));
			int rader = Integer.parseInt(lesFil.nextLine());
			int kolonner = Integer.parseInt(lesFil.nextLine());
			Brett test = new Brett(rader, kolonner, fil, lFil);
			test.faaForste().fyllUtDenneRutenOgResten();
			test.printBrett();
		}			
		
} 