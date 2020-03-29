package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ResultsController {
//Results FXML
    
    @FXML
    private Button RedoGameButton;

    @FXML
    private TextField FinalMessageBox;

    @FXML
    private Label WrongBox;

    @FXML
    private Label ResultsBox;

    @FXML
    private Button MainMenuButton;
    
    public void getMessage(int right, int total){
    	
    	
    	ResultsBox.setText(" " + right + " / " + total);
    	int wrong = total - right;
    	WrongBox.setText(" " + wrong);
    }
}
