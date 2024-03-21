package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MessageView {
	
	public static Scene getScene(String message, Scene back, String backMessage) {
		VBox messageView = new VBox();
		messageView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	messageView.setAlignment(Pos.CENTER);
    	messageView.getChildren().add(Main.logo);
    	messageView.getChildren().add(new Text(message));
    	if (back != null) {
	    	Button messageBack = new Button(backMessage);
	    	messageView.getChildren().add(messageBack);
	    	messageBack.setOnAction(new EventHandler<ActionEvent>() {
	        	public void handle(ActionEvent event) {
	        		Main.setScene(back);
	        	}
	    	});
    	}
    	Scene messageScene = new Scene(messageView, 500, 750);
    	messageScene.setFill(Color.rgb(201, 241, 253));
    	return messageScene;
	}
	
	public static Scene getScene(String message, Scene back) {
		return getScene(message, back, "Back");
	}
	
	public static Scene getScene(String message) {
		return getScene(message, null);
	}
	
	public static Scene getScene() {
		return getScene("Error", null);
	}

}
