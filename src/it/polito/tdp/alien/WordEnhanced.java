package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String p, String t) {
		translations = new LinkedList<String>();
		translations.add(t);
		alienWord = p;
	}
	
	public void setTranslation(String t) {
		// ADESSO DOBBIAMO AGGIUNGERE TRADUZIONI E NON SOSTITUIRLE
		if (!translations.contains(t))
			translations.add(t);
	}
	
	public String getTranslation() {
		// DOBBIAMO EVENTUALMENTE RESTITUIRE PIU' DI UNA TRADUZIONE PER LA STESSA PAROLA
		String ris = "\n";
		for (String s : translations) {
			ris += "<"+s+">" + "\n";
		}
		return ris;
	}
	
	public boolean compareWild(String alienWild) {
		if (alienWord.matches(alienWild))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

}
