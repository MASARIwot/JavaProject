package application;


import myexeption.MyExeption;
import businesslogic.Calculation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
/**
 * 
 * @author Саня
 *
 */
public class Controller {
	
	@FXML 	private Button recon;
	@FXML	private Button exit;
	@FXML	private TextField ao;
	@FXML	private TextField an;
	@FXML	private TextField r;
	@FXML	private TextArea textArea;
	
	@FXML
	public void reconButtonEction(){
		textArea.setText("start");
		try {
			double result = Calculation.calculationTask7(
					Double.parseDouble(ao.getText()),
					Double.parseDouble(an.getText()),
					Double.parseDouble(r.getText())
					
					);
			textArea.setText( Double.toString(result));
		} catch (NumberFormatException e) {
			textArea.setText(e.toString());
		} catch (ArithmeticException e) {
			textArea.setText(e.toString());
		} catch (MyExeption e) {
			textArea.setText(e.getMessage());
		}
		
	}
	@FXML 
	public void exitButtonEction(){
		System.exit(-1);
	}
	

}
