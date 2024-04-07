package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NurseView {
	
	public static Scene getScene(Nurse nurse) {
		
		GridPane nurseView = new GridPane();
		Scene nurseScene = new Scene(nurseView, 1000, 900);
        nurseView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
        nurseView.setAlignment(Pos.TOP_CENTER);
        nurseView.setPadding(new Insets(20));
        nurseView.setHgap(10);
        nurseView.setVgap(10);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(100);
        nurseView.getColumnConstraints().addAll(col1, col2);
        
        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(25);
            nurseView.getRowConstraints().add(row);
        }
        
        
        ImageView newLogo = new ImageView(Main.logo.getImage());
        newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
        GridPane.setHalignment(newLogo, javafx.geometry.HPos.CENTER);
        
        Button logoutButton = new Button("LOG OUT");
        Button replyButton = new Button("REPLY");
        Button confirmButton = new Button("CONFIRM");
        
        logoutButton.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        replyButton.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        confirmButton.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        GridPane.setHalignment(logoutButton, javafx.geometry.HPos.RIGHT);
        GridPane.setHalignment(confirmButton, javafx.geometry.HPos.RIGHT);
        
        logoutButton.setOnAction(event -> Main.setScene(LoginView.getScene()));
        
        VBox patientBox = new VBox(5);
        VBox vitalsBox = new VBox(5);
        VBox allergiesBox = new VBox(5);
        VBox messagesBox = new VBox(5);
        VBox healthConcernsBox = new VBox(5);
        
        Label patientLabel = new Label("Patient Information");
        Label vitalsLabel = new Label("Vitals");
        Label allergiesLabel = new Label("Allergies");
        Label messagesLabel = new Label("Messages");
        Label healthConcernsLabel = new Label("Health Concerns");
        
        patientLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        vitalsLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        allergiesLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        messagesLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        healthConcernsLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        
        TextField patientNameField = new TextField();
        TextField ageField = new TextField();
        TextArea healthIssueArea = new TextArea();
        TextArea immuneHistoryArea = new TextArea();
        TextArea currentPrescriptionsArea = new TextArea();
        TextField weightField = new TextField();
        TextField heightField = new TextField();
        TextField temperatureField = new TextField();
        TextField bloodPressureField = new TextField();
        TextArea allergiesTextArea = new TextArea();
        TextArea healthConcernsArea = new TextArea();
        TextArea messagesArea = new TextArea();
        
        patientNameField.setPromptText("Patient Name");
        ageField.setPromptText("Patient Age");
        healthIssueArea.setPromptText("Previous Health Issues");
        immuneHistoryArea.setPromptText("Immunization History");
        currentPrescriptionsArea.setPromptText("Current Prescriptions");
        weightField.setPromptText("Weight");
        heightField.setPromptText("Height");
        temperatureField.setPromptText("Body Temperature");
        bloodPressureField.setPromptText("Blood Pressure");
        allergiesTextArea.setPromptText("Allergies");
        healthConcernsArea.setPromptText("Health Concerns");
        
        patientNameField.setPrefWidth(150);
        patientNameField.setMaxWidth(150);
        ageField.setPrefWidth(150);
        ageField.setMaxWidth(150);
        healthIssueArea.setPrefWidth(500);
        healthIssueArea.setMaxWidth(500);
        immuneHistoryArea.setPrefWidth(500);
        immuneHistoryArea.setMaxWidth(500);
        currentPrescriptionsArea.setPrefWidth(500);
        currentPrescriptionsArea.setMaxWidth(500);
        weightField.setPrefWidth(150);
        weightField.setMaxWidth(150);
        heightField.setPrefWidth(150);
        heightField.setMaxWidth(150);
        temperatureField.setPrefWidth(150);
        temperatureField.setMaxWidth(150);
        bloodPressureField.setPrefWidth(150);
        bloodPressureField.setMaxWidth(150);
        allergiesTextArea.setPrefWidth(500);
        allergiesTextArea.setMaxWidth(500);
        allergiesTextArea.setPrefHeight(100);
        allergiesTextArea.setMaxHeight(100);
        healthConcernsArea.setPrefWidth(500);
        healthConcernsArea.setMaxWidth(500);
        messagesArea.setPrefWidth(750);
        messagesArea.setMaxWidth(750);
        messagesArea.setPrefHeight(250);
        messagesArea.setMaxHeight(250);
        
        patientBox.getChildren().addAll(patientLabel, patientNameField, ageField, healthIssueArea, immuneHistoryArea, currentPrescriptionsArea);
        vitalsBox.getChildren().addAll(vitalsLabel, weightField, heightField, temperatureField, bloodPressureField);
        allergiesBox.getChildren().addAll(allergiesLabel, allergiesTextArea);
        messagesBox.getChildren().addAll(messagesLabel, messagesArea, replyButton);
        healthConcernsBox.getChildren().addAll(healthConcernsLabel, healthConcernsArea);
        
        nurseView.add(newLogo, 0, 1, 2, 1);
        nurseView.add(logoutButton, 1, 0, 1, 1);
        nurseView.add(patientBox, 0, 3, 1, 2);
        nurseView.add(vitalsBox, 1, 3);
        nurseView.add(allergiesBox, 0, 6, 1, 2);
        nurseView.add(messagesBox, 1, 5, 1, 4);
        nurseView.add(healthConcernsBox, 0, 8, 1, 2);
        nurseView.add(confirmButton, 1, 9, 1, 1);
        
        //nurseView.setGridLinesVisible(true);

       
        return nurseScene;
           
	}
}
