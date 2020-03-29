package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
/*import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL; */
import java.util.Random;
//import java.util.ResourceBundle;
import java.util.Scanner;
//import java.io.IOException;
//import java.util.*;


public class GameController{
	
	public static Random rand = new Random();
    public static Scanner in = new Scanner(System.in);
    private int NumBox;
    private String ModesBox;
    ActionEvent start;
    public static int ans, count = 1;
    static int rand_int1, rand_int2, right = 0;

//Game FXML
    @FXML
    public Label EquationBox;

    @FXML
    public TextField AnswerBox;
   	
    @FXML
    public Label OutcomeBox;
        
    @FXML
    private TextField FinalMessageBox;

    @FXML
    private TextField PercentageBox;

    @FXML
    private TextField ResultsBox;
    
    @FXML
	 public void onEnter(ActionEvent ae) throws IOException{
    	if(count == NumBox){
    		loadRes();
    	}
			 String number = AnswerBox.getText();
			 ans = Integer.parseInt(number); 
			 game(ans);
			 count++;
	 }


public void getMessage(int num, String str){
	NumBox=num;
	ModesBox=str;
	
	rand_int1 = rand.nextInt(10);
    rand_int2 = rand.nextInt(10);
    char op = '+';
    
 	
    
    
    if(ModesBox.equals("Subtraction")) {
   	 op='-';
    	 
    }
    if(ModesBox.equals("Multiplication")) {
   	 op='*';
    	 
    }
    if(ModesBox.equals("Division")) {
   	 op='/';
    	 
    }
    if(ModesBox.equals("Mixture")) {
    	 
    }
    
	 EquationBox.setText("   " + rand_int1 + "\n "+op+" " + rand_int2);
	 
	//System.out.println(NumBox +" " +  ModesBox);
	//game();
}
	
void loadRes() throws IOException{
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Results.fxml"));
	   Parent root = loader.load();
	   ResultsController resController = loader.getController();
	   resController.getMessage(right,count-1);
	   
	   
	  
	   Stage stage = new Stage();
	   stage.setScene(new Scene(root));
	   stage.setTitle("Game");
	   stage.show();

}

   	
     public void game(int ans){
         
         int wrong = 0;
         char op = '+';
         
         	
            
             if(ModesBox.equals("Addition")) {
             	right += add(rand_int1, rand_int2, ans); 
             }
             if(ModesBox.equals("Subtraction")) {
            	 op='-';
             	right += sub(rand_int1, rand_int2); 
             }
             if(ModesBox.equals("Multiplication")) {
            	 op='*';
             	right += mult(rand_int1, rand_int2); 
             }
             if(ModesBox.equals("Division")) {
            	 op='/';
             	right += div(rand_int1, rand_int2); 
             }
             
             rand_int1 = rand.nextInt(10);
             rand_int2 = rand.nextInt(10);
         	 EquationBox.setText("   " + rand_int1 + "\n "+op+" " + rand_int2);
         	 AnswerBox.setText("");
         
         
         
         
      
      }
     
     
      public int add(int num1, int num2, int ans) {
     	 int right = 0;     	 
     	 
          
          if(num1 + num2 == ans){
              OutcomeBox.setText("Correct");
              right++;
          }
          else{
        	  OutcomeBox.setText("Wrong");
          }
     	 return right;
      }
      
      public int sub(int num1, int num2) {
     	 int right = 0;
      	
          
          if(num1 - num2 == ans){
        	  OutcomeBox.setText("Correct");
              right++;
          }
          else{
        	  OutcomeBox.setText("Wrong");
          }
     	 return right;
      }
      
      public int mult(int num1, int num2) {
     	 int right = 0;
     	 
          if(num1 * num2 == ans){
        	  OutcomeBox.setText("Correct");
              right++;
          }
          else{
        	  OutcomeBox.setText("Wrong");
          }
     	 return right;
      }
      
      public int div(int num1, int num2) {
     	 int right = 0;
     	 while((num2 != 0) && (num1 >= num2) && (num1 % num2 == 0)) {
      		num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
      	}
      	
          if(num1 / num2 == ans){
        	  OutcomeBox.setText("Correct");
              right++;
          }
          else{
        	  OutcomeBox.setText("Wrong");
          }
     	 return right;
      }
      
      
}
        
        