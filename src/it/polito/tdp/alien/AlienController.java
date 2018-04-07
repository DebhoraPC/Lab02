package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary dizionario = new AlienDictionary(); 
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;   
   
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    	txtResult.appendText("Welcome to Alien Dictionary v2018.\n");
 
    }
  
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.setText("");
    	String s = txtWord.getText();  
    
    	if (s.length() == 0) {
    		txtResult.setText("Insert one or more words!\n");
    		return;
    	}
    	
    	// GESTIRE 2 EVENTI: INSERIMENTO NUOVA PAROLA E TRADUZIONE/I OPPURE TRADURRE PAROLA ESISTENTE
    	String[] ss = s.toLowerCase().split(" ");
    	String alienword = ss[0];
    	
    	if (!alienword.matches("[a-zA-Z?]+")) {
    		txtResult.appendText("These characters are not allowed! Insert only alphabetical characters!\n");
    		return;
    	}
    	
    	if (ss.length > 1) { 
    		String translation = ss[1];
    		if (!translation.matches("[a-zA-Z]+")) {
    			txtResult.appendText("These characters are not allowed! Insert only alphabetical characters!\n");
    			return;
    		}
			// INSERIMENTO
			dizionario.addWord(alienword, translation); 
			txtResult.appendText("New word/translation added to the Dictionary!\n");
		}
    	else {
    		// DUE POSSIBILI TRADUZIONI (ESERCIZIO OPZIONALE)
    		String trad;
    		if (alienword.matches("[a-zA-Z?]+") && !alienword.matches("[a-zA-Z]+")) {
    			// TRADUZIONE CON JOLLY
    			trad = dizionario.translateWordWildCard(alienword);
    		}
    		else {
    			// TRADUZIONE CLASSICA
    			trad = dizionario.translateWord(alienword);	
    		}
    		if (trad == null)
    			txtResult.appendText("This word does not exist in the dictionary!\n");
    		else
    			txtResult.appendText("The translation/s of " + "<"+alienword+">" + " is/are: " + trad + "\n");
    	}

    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	dizionario.resetDictionary();
    }
    
}
