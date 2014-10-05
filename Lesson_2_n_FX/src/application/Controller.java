package application;
import java.util.ArrayList;
import client.Client;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * This class is processing events from InterfaceGUI.fxml 
 * @author Саня
 *
 */
public class Controller {
  private Client client = new Client();;
	
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private TextArea textAreaIn;
    @FXML
    private TextArea TextAreaResult;
    
    
    @FXML
    public void onClickExit(){
    	 try {
    	  client.closeServer();
    	  TextAreaResult.appendText("Server is Off");
    	 } catch (NullPointerException e) {
 			TextAreaResult.appendText(e.toString() + "\n Server is off \n");
 		}
    	 
    	  ////System.exit(-1);
    }
    @FXML
    public void onClickSort(){
    	TextAreaResult.clear();
    	  ArrayList<String> strArr = new ArrayList<String>();
    	  try {
			strArr = client.sendToServer((client.createArrString(textAreaIn.getText())));
		} catch (NullPointerException e) {
			TextAreaResult.appendText(e.toString() + "\n Server is off \n");
		}
    	  for(String st: strArr){
    	  TextAreaResult.appendText(st + " \n");
    	  }
    }
 
}