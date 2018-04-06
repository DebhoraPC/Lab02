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
    	
    	// CONTROLLO SULL'INPUT
    	if (s.length() == 0) {
    		txtResult.setText("Insert one or more words!\n");
    		return;
    	}
    	if (!isAlpha(s)) {
    		txtResult.appendText("These characters are not allowed! Insert only alphabetical characters!\n");
    	}
    	
    	else {
    		// GESTIRE 2 EVENTI: INSERIMENTO NUOVA PAROLA E TRADUZIONE/I OPPURE TRADURRE PAROLA ESISTENTE
    		String[] ss = s.toLowerCase().split(" ");
    		if (ss.length > 1) { 
    			// INSERIMENTO
    			dizionario.addWord(ss[0], ss[1]); 
    			txtResult.appendText("New word/translation added to the Dictionary!\n");
    		}
    		else {
    			// TRADUZIONE
    			String trad = dizionario.translateWord(ss[0]);
    			if (trad == null) {
    				txtResult.appendText("This word does not exist in the dictionary!\n");
    			}
    			else {
    				txtResult.appendText("The translation/s of " + "<"+ss[0]+">" + " is/are: " + trad + "\n");
    			}
    		}
    	}

    }
    
    boolean isAlpha(String s) {
    	
    	// espresione regex da cui deve essere formato l'input: (^)([a-zA-Z]+)(&), ^ definisce l'inizio 
    	// della parola mentre & definisce la sua fine, la parte in mezzo dice che la parola può essere
    	// composta di caratteri a-z oppure A-Z e possono essere duplicati ecco perché il +
    	
    	//return s.matches("(^)([a-zA-Z]+)(&)"); non funziona più così 
    	
    	String[] ss = s.split(" ");
    	if (ss.length > 1) {
    		if (ss[0].matches("[a-zA-Z]+") && ss[1].matches("[a-zA-Z]+")) 
    			return true;
    		else
    			return false;
    	}
    	return s.matches("[a-zA-Z]+");
    	
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	dizionario.resetDictionary();
    }
    
}
