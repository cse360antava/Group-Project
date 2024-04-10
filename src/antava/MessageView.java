package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class MessageView {
	public static Scene getScene(User user, Message m) {
		VBox messageView = new VBox(15);
    	messageView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	messageView.setAlignment(Pos.CENTER);
    	
    	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
    	
    	Scene messageScene = new Scene(messageView, screenWidth, screenHeight);
    	messageScene.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
    	Text title = new Text("View Message");
    	title.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
    	title.setStyle("-fx-fill: rgba(170, 103, 29, 0.8);");
    	messageView.getChildren().add(newLogo);
    	messageView.getChildren().add(title);
    	
		Text t = new Text(m.toString());
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
    			if (user instanceof Patient) {
    				Main.setScene(PatientView.getScene((Patient)user));
    			} else if (user instanceof Nurse) {
    				Main.setScene(NurseView.getScene((Nurse)user));
    			} else { // Doctor
    				Main.setScene(DoctorView.getScene((Doctor)user));
    			}
    		}
    	});
    	
    	Button backButton = new Button("Cancel");
    	backButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			if (user instanceof Patient) {
    				Main.setScene(PatientView.getScene((Patient)user));
    			} else if (user instanceof Nurse) {
    				Main.setScene(NurseView.getScene((Nurse)user));
    			} else { // Doctor
    				Main.setScene(DoctorView.getScene((Doctor)user));
    			}
    		}
    	});
    	
    	HBox messageButtons = new HBox(25);
    	messageButtons.getChildren().addAll(replyButton, delButton, backButton);
    	messageButtons.setAlignment(Pos.CENTER);
    	messageView.getChildren().addAll(t, messageButtons);
    	
		return messageScene;
	}
}
