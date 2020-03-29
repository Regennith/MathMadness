package application;
	
//import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	static Stage primaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception{
		Pane root = (Pane) FXMLLoader.load(Main.class.getResource("Math Madness.fxml")); 		//Import from SceneBuilder fxml file
		Scene scene = new Scene(root); 															//Create new scene
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //Add style to scene
		primaryStage.setScene(scene);															//Set scene			
		primaryStage.setTitle("Math Madness");											//Set Title
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	
}
