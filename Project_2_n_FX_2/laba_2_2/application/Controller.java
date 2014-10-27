package application;
import interface_home2_2.HomeTaskInterface;


import java.util.ArrayList;
import java.util.StringTokenizer;

import task2_2.HomeTaskVisitor;
import task2_2.Home_Task_1;
import task2_2.Home_Task_2;

import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

/**
 * This class is processing events from InterfaceGUI.fxml 
 * @author Саня
 *
 */
public class Controller {
 
	
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private TextArea textAreaIn;
    @FXML
    private TextArea TextAreaResult;
    @FXML
    private RadioButton ButtonCleane;
    
    @FXML
    public void onSwich(){
    	textAreaIn.clear();
    }
    @FXML
    public void onClickSortInt(){
    	TextAreaResult.clear();
    	HomeTaskInterface nomeTAsk2 = new Home_Task_2();
    	ArrayList<String> strArr = new ArrayList<String>();
    	 try {
    	 strArr = nomeTAsk2.accept(new HomeTaskVisitor() ,createArrString(textAreaIn.getText()));
    	 } catch (NullPointerException |NumberFormatException | IndexOutOfBoundsException e) {
 			TextAreaResult.appendText(e.toString() + "\n Please Write number from 0..9");
 		 }
    	 for(String st: strArr){
       	  TextAreaResult.appendText(st + " \n");
       	  }
    	
    }
    @FXML
    public void onClickSortString(){
    	TextAreaResult.clear();
    	HomeTaskInterface nomeTAsk = new Home_Task_1();
    	ArrayList<String> strArr = new ArrayList<String>();
    	  try {
			  strArr = nomeTAsk.accept(new HomeTaskVisitor() ,createArrString(textAreaIn.getText()));
		} catch (NullPointerException |ArithmeticException e) {
			TextAreaResult.appendText(e.toString() + "Do Somesing");
		}
    	  for(String st: strArr){
    	  TextAreaResult.appendText(st + " \n");
    	  }
    	  
    }  
      private  ArrayList<String> createArrString(String strIn){
    			ArrayList<String> arrString = new ArrayList<String>();
       			// пробел,\t\n\r,. -разделители
    			StringTokenizer strArrv = new StringTokenizer(strIn, " \t\n\r,."); 
	    			while(strArrv.hasMoreTokens()){ 
	    				arrString.add(strArrv.nextToken());
	    			}
	return arrString;
   		}  
    
 
}