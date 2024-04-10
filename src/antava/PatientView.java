package antava;

import java.util.ArrayList;

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
import javafx.stage.Screen;


public class PatientView {
	
	public static Scene getScene(Patient patient) {
		
		GridPane patientView = new GridPane();
		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        Scene patientScene = new Scene(patientView, screenWidth, screenHeight);
        patientView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
        patientView.setAlignment(Pos.TOP_CENTER);
        patientView.setPadding(new Insets(20));
        patientView.setHgap(10);
        patientView.setVgap(10);       
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(100);
        patientView.getColumnConstraints().addAll(col1, col2);
        
        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(25);
            patientView.getRowConstraints().add(row);
        }
        
        
        ImageView newLogo = new ImageView(Main.logo.getImage());
        newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
        GridPane.setHalignment(newLogo, javafx.geometry.HPos.CENTER);
        
        Button logoutButton = new Button("Log Out");
        Button composeButton = new Button("Compose Message");
        Button confirmButton = new Button("Confirm");
        
        GridPane.setHalignment(logoutButton, javafx.geometry.HPos.RIGHT);
        GridPane.setHalignment(confirmButton, javafx.geometry.HPos.RIGHT);
        
        logoutButton.setOnAction(event -> Main.setScene(LoginView.getScene()));
        
        VBox patientInfoBox = new VBox(10);
        VBox messagesBox = new VBox(5);
        VBox visitHistoryBox = new VBox(5);
        
        Label patientInfoLabel = new Label("Patient Info");
        Label messagesLabel = new Label("Messages");
        Label visitHistoryLabel = new Label("Visit History");
        
        patientInfoLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        messagesLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        visitHistoryLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField birthDayField = new TextField();
        TextField birthMonthField = new TextField();
        TextField birthYearField = new TextField();
        TextField ageField = new TextField();
        TextField patientEmailField = new TextField();
        TextField patientPhoneNumberField = new TextField();
        TextField insuranceField = new TextField();
        TextField pharmacyField = new TextField();
        TextArea healthIssueArea = new TextArea();
        TextArea immuneHistoryArea = new TextArea();
        TextArea currentPrescriptionsArea = new TextArea();
        TextArea visitHistoryArea = new TextArea();

        firstNameField.setPromptText("First Name");
        lastNameField.setPromptText("Last Name");
        birthDayField.setPromptText("Birth Day");
        birthMonthField.setPromptText("Birth Month");
        birthYearField.setPromptText("Birth Year");
        ageField.setPromptText("Age");
        patientEmailField.setPromptText("Patient Email");
        patientPhoneNumberField.setPromptText("Patient Phone Number");
        insuranceField.setPromptText("Insurance Company");
        pharmacyField.setPromptText("Pharmacy");
        healthIssueArea.setPromptText("Health Issues");
        immuneHistoryArea.setPromptText("Immunization History");
        currentPrescriptionsArea.setPromptText("Current Prescriptions");
        visitHistoryArea.setPromptText("Visit History");
        
        firstNameField.setText((String) patient.patientData.getDataRepo().get("firstName"));
        lastNameField.setText((String) patient.patientData.getDataRepo().get("lastName"));
        birthDayField.setText((String) patient.patientData.getDataRepo().get("birthDay"));
        birthMonthField.setText((String) patient.patientData.getDataRepo().get("birthMonth"));
        birthYearField.setText((String) patient.patientData.getDataRepo().get("birthYear"));
        ageField.setText((String) patient.patientData.getDataRepo().get("age"));
        patientEmailField.setText((String) patient.patientData.getDataRepo().get("email"));
        patientPhoneNumberField.setText((String) patient.patientData.getDataRepo().get("phoneNumber"));
        insuranceField.setText((String) patient.patientData.getDataRepo().get("insuranceCompany"));
        pharmacyField.setText((String) patient.patientData.getDataRepo().get("pharmacy"));
        healthIssueArea.setText((String) patient.patientData.getDataRepo().get("previousHealthIssues"));
        immuneHistoryArea.setText((String) patient.patientData.getDataRepo().get("immunizationHistory"));
        currentPrescriptionsArea.setText((String) patient.patientData.getDataRepo().get("currentPrescriptions")); 
        
        ArrayList<Visit> visitHistory = (ArrayList<Visit>) patient.patientData.getDataRepo().get("visitHistory");
        if (!visitHistory.isEmpty()) {
	        for(Visit pVisit: visitHistory) {
	        	visitHistoryArea.appendText(pVisit.getPatientVisit());
	        }
        }
      
        firstNameField.setPrefWidth(150);
        firstNameField.setMaxWidth(150);
        lastNameField.setPrefWidth(150);
        lastNameField.setMaxWidth(150);
        birthDayField.setPrefWidth(150);
        birthDayField.setMaxWidth(150);
        birthMonthField.setPrefWidth(150);
        birthMonthField.setMaxWidth(150);
        birthYearField.setPrefWidth(150);
        birthYearField.setMaxWidth(150);
        ageField.setPrefWidth(150);
        ageField.setMaxWidth(150);
        insuranceField.setPrefWidth(150);
        insuranceField.setMaxWidth(150);
        pharmacyField.setPrefWidth(150);
        pharmacyField.setMaxWidth(150);
        patientEmailField.setPrefWidth(150);
        patientEmailField.setMaxWidth(150);
        patientPhoneNumberField.setPrefWidth(150);
        patientPhoneNumberField.setMaxWidth(150);
        visitHistoryArea.setPrefWidth(500);
        visitHistoryArea.setMaxWidth(500);
        healthIssueArea.setPrefWidth(500);
        healthIssueArea.setMaxWidth(500);
        immuneHistoryArea.setPrefWidth(500);
        immuneHistoryArea.setMaxWidth(500);
        currentPrescriptionsArea.setPrefWidth(500);
        currentPrescriptionsArea.setMaxWidth(500);
        visitHistoryArea.setPrefWidth(750);
        visitHistoryArea.setMaxWidth(750);
        visitHistoryArea.setPrefHeight(250);
        visitHistoryArea.setMaxHeight(250);
        
        HBox messages = new HBox(25);
        ArrayList<Message> ms = MessageRepo.getTo(patient.getID());
        for (Message m : ms) {
        	messages.getChildren().add(MessageBar.getNode(m, patient));
        }
        if (ms.isEmpty()) {
        	messages.getChildren().add(new Text("No messages."));
        }
        
        HBox nameBox = new HBox(25);
        HBox birthBox = new HBox(25);
        HBox patientContactBox = new HBox(25);
        HBox insuranceBox = new HBox(25);
        nameBox.getChildren().addAll(firstNameField, lastNameField, ageField);
        birthBox.getChildren().addAll(birthDayField, birthMonthField, birthYearField);
        patientContactBox.getChildren().addAll(patientEmailField, patientPhoneNumberField);
        insuranceBox.getChildren().addAll(insuranceField, pharmacyField);
        patientInfoBox.getChildren().addAll(patientInfoLabel, nameBox, birthBox, patientContactBox, insuranceBox,
        									healthIssueArea, immuneHistoryArea, currentPrescriptionsArea);
        messagesBox.getChildren().addAll(messagesLabel, messages, composeButton);
        visitHistoryBox.getChildren().addAll(visitHistoryLabel, visitHistoryArea);
        
        patientView.add(newLogo, 0, 1, 2, 1);
        patientView.add(logoutButton, 1, 0, 1, 1);
        patientView.add(patientInfoBox, 0, 3, 1, 2);  
        patientView.add(messagesBox, 1, 3, 1, 4);
        patientView.add(visitHistoryBox, 0, 6, 1, 3);
        patientView.add(confirmButton, 1, 9, 1, 1);
        
        composeButton.setOnAction(event -> {
        	Main.setScene(ComposeView.getScene(patient, null));
        });
        
        confirmButton.setOnAction(event -> {
        	
        	String firstName = firstNameField.getText();
        	String lastName = lastNameField.getText();
        	String birthDay = birthDayField.getText();
        	String birthMonth = birthMonthField.getText();
        	String birthYear = birthYearField.getText();
        	String age = ageField.getText();
        	String patientEmail = patientEmailField.getText();
        	String patientNumber = patientPhoneNumberField.getText();
        	String insuranceName = insuranceField.getText();
        	String pharmacy = pharmacyField.getText();
            String healthIssues = healthIssueArea.getText();
            String immuneHistory = immuneHistoryArea.getText();
            String currentPrescriptions = currentPrescriptionsArea.getText();
            
            patient.patientData.editPatientData("firstName", firstName);
            patient.patientData.editPatientData("lastName", lastName);
            patient.patientData.editPatientData("birthDay", birthDay);
            patient.patientData.editPatientData("birthMonth", birthMonth);
            patient.patientData.editPatientData("birthYear", birthYear);
            patient.patientData.editPatientData("age", age);
            patient.patientData.editPatientData("email", patientEmail);
            patient.patientData.editPatientData("phoneNumber", patientNumber);
            patient.patientData.editPatientData("insuranceCompany", insuranceName);
            patient.patientData.editPatientData("pharmacy", pharmacy);
            patient.patientData.editPatientData("previousHealthIssues", healthIssues);
            patient.patientData.editPatientData("immunizationHistory", immuneHistory);
            patient.patientData.editPatientData("currentPrescriptions", currentPrescriptions);
            patient.createPatientID();
            patient.patientData.editPatientData("patientID", patient.getPatientID());
  
        	System.out.println("Patient ID: " + (String) patient.patientData.getDataRepo().get("patientID") + "\n");
        });
        
        //patientView.setGridLinesVisible(true);

       
        return patientScene;
           
	}
}
