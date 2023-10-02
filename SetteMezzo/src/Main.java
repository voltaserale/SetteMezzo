import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean[] carte=new boolean[40];
		String[] valori= {"asso", "due", "tre", "quattro","cinque",
							"sei","sette","fante","cavallo","re"};
		String[] semi= {"spade","coppe","bastoni","denari"};
		
		double punteggioUtente=0, punteggioPC=0;
		
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		String risposta;
		int pos;
		int valore;
		int seme;
		
		for(int i=0;i<40;i++)		//inizializzo il vettore delle carte
			carte[i]=false;
		
		System.out.println("Benvenuto al gioco 7 e 1/2\n");
		System.out.println("Turno dell'utente.");
	
		do {
			System.out.print("Vuoi estrarre una carta (s/n): ");
			risposta=sc.nextLine();
			
			if (risposta.equals("s"))
			{
				
				do {
					pos=r.nextInt(40);		//numero casuale tra 0 e 39
				} while (carte[pos]);		//equivale carte[pos]==true (se la carta è già uscita allora carte[pos]==true e si genera un altro numero)
				carte[pos]=true; 			//segno che la carta è uscita
				seme=pos/10;
				valore=pos%10;			//resto della divisione intera
				System.out.println("E' uscito: "+valori[valore]+ " di "+ semi[seme]);
				if (valore<7)
					punteggioUtente+=valore+1; 	//punteggioUtente=punteggioUtente+valore
				else
					punteggioUtente+=0.5;
				System.out.println("Punteggio: "+punteggioUtente);
				if (punteggioUtente>7.5) 
					System.out.println("Hai perso!");
			}
			
		} while(punteggioUtente<=7.5 && risposta.equals("s"));
		if (punteggioUtente<=7.5) {
			System.out.println("\nTurno del computer.");
			do {	
					do {
						pos=r.nextInt(40);		//numero casuale tra 0 e 39
					} while (carte[pos]);		//equivale carte[pos]==true (se la carta è già uscita allora carte[pos]==true e si genera un altro numero)
					carte[pos]=true; 			//segno che la carta è uscita
					seme=pos/10;
					valore=pos%10;			//resto della divisione intera
					System.out.println("E' uscito: "+valori[valore]+ " di "+ semi[seme]);
					if (valore<7)
						punteggioPC+=valore+1; 	//punteggioUtente=punteggioUtente+valore
					else
						punteggioPC+=0.5;
					System.out.println("Punteggio: "+punteggioPC);				
				
				
			} while(punteggioPC<7.5 && punteggioPC<punteggioUtente);
			if (punteggioPC<=7.5)
				System.out.println("Ho vinto!");
			else
				System.out.println("Ho perso!");
		}
		
			
		sc.close();
	}

}

