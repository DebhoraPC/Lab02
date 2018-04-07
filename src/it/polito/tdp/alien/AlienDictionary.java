package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	//private List<Word> parole; // LISTA DI OGGETTI DI TIPO WORD
	private List<WordEnhanced> parole; // LISTA DI OGGETTI DI TIPO WORDENHANCED
	
	public AlienDictionary() {
		//parole = new LinkedList<Word>();
		parole = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation) {
		
		//Word p = new Word(alienWord, translation); 
		WordEnhanced p = new WordEnhanced(alienWord, translation);
		
		for (/*Word*/ WordEnhanced w : parole) {
			if (w.equals(p)) {
				w.setTranslation(translation);
				return;
			}
		}
		parole.add(p);	
		
	}
	
	public String translateWord(String alienWord) {
		
		//Word p = new Word(alienWord,"");
		WordEnhanced p = new WordEnhanced(alienWord,"");
		
		for (/*Word*/ WordEnhanced w : parole) {
			if (w.equals(p)) {
				return w.getTranslation();
			}
		}
		return null;
		
	}
	
	public String translateWordWildCard(String alienWord) {
		
		alienWord = alienWord.replaceAll("\\?", ".");
		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();
		
		for (WordEnhanced w : parole) {
			if (w.compareWild(alienWord)) {
				matchCounter++;
				sb.append(w.getTranslation());
			}
		}
		
		if (matchCounter != 0)
			return sb.toString();
		else
			return null;

	}

	public void resetDictionary() {
		parole.clear();
		
	}

}
