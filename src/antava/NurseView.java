package antava;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
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
import javafx.stage.Screen;

public class NurseView {
	
	public static Scene getScene(Nurse nurse) {
		
		GridPane nurseView = new GridPane();
		
		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        Scene nurseScene = new Scene(nurseView, screenWidth, screenHeight);
        
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
        newLogo.setFitWidth(200); 
    	newLogo.setFitHeight(200);
        GridPane.setHalignment(newLogo, javafx.geometry.HPos.CENTER);
        
        Button logoutButton = new Button("Log Out");
        Button confirmButton = new Button("Confirm");
        
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
        
        TextField patientIDField = new TextField();
        TextField patientNameField = new TextField();
        TextField ageField = new TextField();
        TextArea healthIssueArea = new TextArea();
        TextArea immuneHistoryArea = new TextArea();
        TextArea currentPrescriptionsArea = new TextArea();
        TextField weightField = new TextField();
        TextField heightField = new TextField();
        TextField temperatureField = new TextField();
        TextField bloodPressureField = new TextField();
        TextArea allergiesArea = new TextArea();
        TextArea healthConcernsArea = new TextArea();
        
        patientIDField.setPromptText("Patient ID");
        patientNameField.setPromptText("Patient Name");
        ageField.setPromptText("Patient Age");
        healthIssueArea.setPromptText("Previous Health Issues");
        immuneHistoryArea.setPromptText("Immunization History");
        currentPrescriptionsArea.setPromptText("Current Prescriptions");
        weightField.setPromptText("Weight");
        heightField.setPromptText("Height");
        temperatureField.setPromptText("Body Temperature");
        bloodPressureField.setPromptText("Blood Pressure");
        allergiesArea.setPromptText("Allergies");
        healthConcernsArea.setPromptText("Health Concerns");
        
        // Check Age
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            checkAge(ageField, weightField, heightField, temperatureField, bloodPressureField);
        });
        
        patientIDField.setPrefWidth(150);
        patientIDField.setMaxWidth(150);
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
        allergiesArea.setPrefWidth(500);
        allergiesArea.setMaxWidth(500);
        allergiesArea.setPrefHeight(100);
        allergiesArea.setMaxHeight(100);
        healthConcernsArea.setPrefWidth(500);
        healthConcernsArea.setMaxWidth(500);
        
        VBox messages = new VBox(25);
        ArrayList<Message> ms = MessageRepo.getTo(nurse.getID());
        for (Message m : ms) {
        	messages.getChildren().add(MessageBar.getNode(m, nurse));
        }
        if (ms.isEmpty()) {
        	messages.getChildren().add(new Text("No messages."));
        }
        
        Button composeButton = new Button("Compose Message");
        composeButton.setOnAction(event -> {
        	Main.setScene(ComposeView.getScene(nurse, null));
        });
        
        patientBox.getChildren().addAll(patientLabel, patientIDField, patientNameField, ageField, healthIssueArea, immuneHistoryArea, currentPrescriptionsArea);
        vitalsBox.getChildren().addAll(vitalsLabel, weightField, heightField, temperatureField, bloodPressureField);
        allergiesBox.getChildren().addAll(allergiesLabel, allergiesArea);
        messagesBox.getChildren().addAll(messagesLabel, messages, composeButton);
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
        patientIDField.textProperty().addListener((observable, oldValue, newValue) -> {
            getPatientInfo(nurse, patientIDField, patientNameField, healthIssueArea, immuneHistoryArea, currentPrescriptionsArea, ageField);
        });
        
        confirmButton.setOnAction(event -> {
        	String patientID = patientIDField.getText();
        	String weight = weightField.getText();
        	String height = heightField.getText();
        	String temperature = temperatureField.getText();
            String bloodPressure = bloodPressureField.getText();
            String allergies = allergiesArea.getText();
            String healthConcerns = healthConcernsArea.getText();
            nurse.setPatient(patientID);
            Patient curPatient = nurse.getPatient();
            if (curPatient != null) {
            	PatientDataRepository patientRepo = curPatient.patientData;
            	patientRepo.editPatientData("weight", weight);
            	patientRepo.editPatientData("height", height);
            	patientRepo.editPatientData("bodyTemperature", temperature);
            	patientRepo.editPatientData("bloodPressure", bloodPressure);
            	patientRepo.editPatientData("allergies", allergies);
            	patientRepo.editPatientData("healthConcerns", healthConcerns);
            	  
            	System.out.println("Patient Information Added By Nurse");
            }
            
        }); 

        return nurseScene;
           
	}
	
	public static void checkAge(TextField ageField, TextField weightField, TextField heightField, TextField temperatureField, TextField bloodPressureField) {
		int patientAge = 0;
		
        try {
        	patientAge = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException exception) {
        	
        }
        
        if( patientAge > 12) 
        {
        	weightField.setEditable(true);
            heightField.setEditable(true);
            temperatureField.setEditable(true);
            bloodPressureField.setEditable(true);
        } else {
        	weightField.setEditable(false);
            heightField.setEditable(false);
            temperatureField.setEditable(false);
            bloodPressureField.setEditable(false);
        }   
	}
	
	public static void getPatientInfo(Nurse nurse, TextField patientIDField, TextField patientNameField, TextArea healthIssueArea, TextArea immuneHistoryArea, TextArea currentPrescriptionsArea, TextField ageField) {
		String patientID = patientIDField.getText();
		nurse.setPatient(patientID);
        Patient curPatient = nurse.getPatient();
        if (curPatient != null) {
        	PatientDataRepository patientRepo = curPatient.patientData;
        	
        	patientNameField.setText((String) patientRepo.getDataRepo().get("firstName") + " "  
        	+ (String) patientRepo.getDataRepo().get("lastName"));
        	
        	ageField.setText((String) patientRepo.getDataRepo().get("age"));
        	healthIssueArea.setText((String) patientRepo.getDataRepo().get("previousHealthIssues"));
            immuneHistoryArea.setText((String) patientRepo.getDataRepo().get("immunizationHistory"));
            currentPrescriptionsArea.setText((String) patientRepo.getDataRepo().get("currentPrescriptions"));
        	nurse.currentPatient = null;
        } else {
        	patientNameField.setText("");
        	ageField.setText("");
        	healthIssueArea.setText("");
        	immuneHistoryArea.setText("");
        	currentPrescriptionsArea.setText("");
        }
	}
	
}
