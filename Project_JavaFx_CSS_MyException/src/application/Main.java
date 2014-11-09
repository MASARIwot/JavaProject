package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Parent root = FXMLLoader.load(getClass().getResource("InterfaceFx.fxml"));
//	        primaryStage.setTitle("Task 2.1");
//	        primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
//	        primaryStage.show();
			
			Parent root = FXMLLoader.load(getClass().getResource("InterfaceFx.fxml"));
			Scene scene = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("сумма геометрической прогрессии-> Task 7.6");
//			primaryStage.setHeight(274);
//			primaryStage.setWidth(397);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
