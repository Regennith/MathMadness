package application;

import javafx.scene.control.Button;
import java.io.IOException;

//import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;



public class MainController implements Initializable{

	//Math Madness FXML
	ObservableList<String> ModesList = FXCollections.observableArrayList("Addition","Subtraction","Multiplication","Division");
	ObservableList<Integer> NumList = FXCollections.observableArrayList(15,30,40,50,60);
	
    @FXML
    private Label Modes;

    @FXML
    private Label Num;

    
    @FXML
    public ChoiceBox<Integer> NumBox;

    @FXML
    public Label Title;

    @FXML
    public Pane rootPane;
    
    @FXML
    public ChoiceBox<String> ModesBox;
    
    @FXML
    public Button myButton;
    
    @Override 
    public void initialize(URL url, ResourceBundle rb){
        ModesBox.setValue("Addition");
        ModesBox.setItems(ModesList);
    	NumBox.setValue(15);
    	NumBox.setItems(NumList);
    	myButton.setOnAction((event) -> {
    		try {
				loadGame();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    
    }
    	
  
   public void loadGame() throws IOException{
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
	   Parent root = loader.load();
	   GameController gameController = loader.getController();
	   gameController.getMessage(NumBox.getValue(),ModesBox.getValue());
	   
	   
	  
	   Stage stage = new Stage();
	   stage.setScene(new Scene(root));
	   stage.setTitle("Page 2");
	   stage.show();
   }
        
    
    
}
