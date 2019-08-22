package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setTitle("Avrdude Burner - by Lodacir da Rosa");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
