package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MessageBar {
	public static Node getNode(Message m, User user) {
		HBox hs = new HBox(10);
		Text t = new Text("From: " + m.sender + "\n" + "Subject: " + m.subject + "\n");
		Button replyButton = new Button("View");
    	replyButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			Main.setScene(MessageView.getScene(user, m));
    		}
    	});
    	
    	hs.getChildren().addAll(t, replyButton);
    	
		return hs;
	}
}
