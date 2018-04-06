package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation; 
	
	public Word(String p, String t) {
		this.alienWord = p;
		this.translation = t;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	public void setTranslation(String t) {
		this.translation = t;
	}
	
	public String getTranslation() {
		return "\n<" + this.translation + ">\n";
	}

}
