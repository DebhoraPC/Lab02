package it.polito.tdp.alien;

// ALCUNI TEST PER CONTROLLARE IL CORRETTO FUNZIONAMENTO

public class Test {

	public static void main(String[] args) {
		
		AlienDictionary dizionario = new AlienDictionary();
	
		int dim = 12; 
		String[] parole = new String[dim]; // elenco di parole random
		String s; int j = 0;
		while (j < dim) {
			s = "";
			for (int i=0; i<5; i++) {
				int ints = (int)(Math.random()*25) + 97; // intero random da 97 a 97+25=122 codice ASCII
				s += (char) ints; 
			}
			parole[j] = s;
			j++;
		}
		
		// TEST PER L'ESERCIZIO 1
		j=0;
		while (j < dim) {
			dizionario.addWord(parole[j], parole[j+1]);
			System.out.println("Parola: " + parole[j] + " e traduzione: " + parole[j+1] + " aggiunte!\n");
			j = j+2;
		}
		j=0;
		while (j < dim) {
			String t = dizionario.translateWord(parole[j]);
			if(t == null) 
				System.out.println("La parola " + parole[j] + " non esiste nel dizionario!\n");
			else
				System.out.println("La traduzione di <" + parole[j] + "> è: " + t + "\n");
			j++;
		}
		dizionario.resetDictionary();
		if (dizionario.translateWord(parole[0]) == null) 
			System.out.println("Dizionario vuoto!\n");
		
		// TEST PER L'ESERCIZIO 2 (NO OPZIONALE)
		j=0;
		while (j < dim) {
			dizionario.addWord(parole[j], parole[j+1]);
			System.out.println("Parola: " + parole[j] + " e traduzione: " + parole[j+1] + " aggiunte!\n");
			dizionario.addWord(parole[j], parole[j+2]);
			System.out.println("Parola: " + parole[j] + " e traduzione: " + parole[j+2] + " aggiunte!\n");
			j = j+3;
		}
		j=0;
		while (j < dim) {
			String t = dizionario.translateWord(parole[j]);
			if(t == null) 
				System.out.println("La parola " + parole[j] + " non esiste nel dizionario!\n");
			else
				System.out.println("La traduzione di <" + parole[j] + "> è: " + t + "\n");
			j++;
		}
		dizionario.resetDictionary();
		if (dizionario.translateWord(parole[0]) == null) 
			System.out.println("Dizionario vuoto!\n");	
			
	}

}
