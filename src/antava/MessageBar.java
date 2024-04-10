package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MessageBar {
	public static Node getNode(Message m, User user) {
		HBox hs = new HBox();
		Text t = new Text("From: " + m.sender + "\n" + m.subject);
		Button replyButton = new Button("Reply");
    	replyButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			Main.setScene(ComposeView.getScene(user, "RE: " + m.subject, m.sender));
    		}
    	});
    	Button delButton = new Button("Delete");
    	delButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			MessageRepo.delete(m);
    			hs.getChildren().clear();
    		}
    	});
    	
    	hs.getChildren().addAll(t, replyButton, delButton);
    	
		return hs;
	}
}
