package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class ComposeView {
	public static Scene getScene(User user, String subject, String to) {
		String sender = user.getID();
		String senderName = user.getAccount().getUsername();
		//System.out.println(senderName);
		VBox composeView = new VBox(10);
    	composeView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	composeView.setAlignment(Pos.CENTER);
    	
    	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 250;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 250;
    	
    	Scene composeScene = new Scene(composeView, screenWidth, screenHeight);
    	composeScene.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
    	Text title = new Text("Compose Message");
    	title.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
    	title.setStyle("-fx-fill: rgba(170, 103, 29, 0.8);");
    	composeView.getChildren().add(newLogo);
    	composeView.getChildren().add(title);
    	
    	Text fromText = new Text("From: " + senderName);
    	composeView.getChildren().add(fromText);
    	
    	Label toLabel = new Label("To:");
    	
    	ToggleGroup toGroup = new ToggleGroup();
    	RadioButton nurseButton = new RadioButton("Nurse");
        RadioButton doctorButton = new RadioButton("Doctor");
        nurseButton.setToggleGroup(toGroup);
        doctorButton.setToggleGroup(toGroup);
        nurseButton.setSelected(true);
        
        TextField patientField = new TextField();
        patientField.setPromptText("Patient ID");
        patientField.setPrefWidth(500);
        patientField.setMaxWidth(500);
        
    	if (user instanceof Patient) {
    		if (to != null && to.equals("doctor")) {
    			doctorButton.setSelected(true);
    		}
	        composeView.getChildren().addAll(toLabel, nurseButton, doctorButton);

    	} else {
    		if (to != null) {
    			patientField.setText(to);
    		}
    		composeView.getChildren().addAll(toLabel, patientField);
    	}
    	
    	TextField subjectField = new TextField();
        subjectField.setPromptText("Subject");
        subjectField.setPrefWidth(500);
        subjectField.setMaxWidth(500);
        
        if (subject != null) {
        	subjectField.setText(subject);
        }
        
        TextArea body = new TextArea();
        body.setPrefWidth(500);
        body.setMaxWidth(500);
        body.setPrefHeight(150);
        body.setMaxHeight(150);
        body.setPromptText("Message...");
        
    	composeView.getChildren().addAll(subjectField, body);
    	
        HBox messageButtons = new HBox(25);
        messageButtons.setAlignment(Pos.CENTER);
        Button sendButton = new Button("Send");
        messageButtons.getChildren().add(sendButton);
    	sendButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			String to;
    			if (user instanceof Patient) {
    				to = nurseButton.isSelected() ? "nurse" : "doctor";
    			} else {
    				to = patientField.getText();
    			}
    			Message m = new Message(sender, to, subjectField.getText(), body.getText());
    			MessageRepo.compose(m);
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
        messageButtons.getChildren().add(backButton);
        composeView.getChildren().add(messageButtons);
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
    	    	
    	return composeScene;
	}
	
	public static Scene getScene(User user, String subject) {
		return getScene(user, subject, null);
	}
	
}
