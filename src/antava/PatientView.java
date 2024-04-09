package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class PatientView {
	
	public static Scene getScene(Patient patient) {
		// TODO: this is a placeholder
		VBox patientView = new VBox();
		patientView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
		patientView.setAlignment(Pos.CENTER);
		
		double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        Scene patientScene = new Scene(patientView, screenWidth, screenHeight);
    	patientScene.setFill(Color.rgb(201, 241, 253));
    	
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
    	
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField birthDayField = new TextField();
        TextField birthMonthField = new TextField();
        TextField birthYearField = new TextField();
        TextField ageField = new TextField();
        TextArea healthIssueArea = new TextArea();
        TextArea immuneHistoryArea = new TextArea();
        TextArea currentPrescriptionsArea = new TextArea();
        
        firstNameField.setPromptText("First Name");
        lastNameField.setPromptText("Last Name");
        birthMonthField.setPromptText("Month");
        birthDayField.setPromptText("Day");
        birthYearField.setPromptText("Year");
        ageField.setPromptText("Age");
        healthIssueArea.setPromptText("Health");
        immuneHistoryArea.setPromptText("Immune");
        currentPrescriptionsArea.setPromptText("Medication");
        
        Button logoutButton = new Button("Log Out");
        Button confirmButton = new Button("Confirm");
        
        logoutButton.setOnAction(event -> Main.setScene(LoginView.getScene()));
        confirmButton.setOnAction(event -> {
        	
        	String firstName = firstNameField.getText();
        	String lastName = lastNameField.getText();
        	String birthDay = birthDayField.getText();
        	String birthMonth = birthMonthField.getText();
        	String birthYear = birthYearField.getText();
        	String age = ageField.getText();
            String healthIssues = healthIssueArea.getText();
            String immuneHistory = immuneHistoryArea.getText();
            String currentPrescriptions = currentPrescriptionsArea.getText();
            
            patient.patientData.editPatientData("firstName", firstName);
            patient.patientData.editPatientData("lastName", lastName);
            patient.patientData.editPatientData("birthDay", birthDay);
            patient.patientData.editPatientData("birthMonth", birthMonth);
            patient.patientData.editPatientData("birthYear", birthYear);
            patient.patientData.editPatientData("age", age);
            patient.patientData.editPatientData("previousHealthIssues", healthIssues);
            patient.patientData.editPatientData("immunizationHistory", immuneHistory);
            patient.patientData.editPatientData("currentPrescriptions", currentPrescriptions);
            patient.createPatientID();
  
        	System.out.println("First Name: " + (String) patient.patientData.getDataRepo().get("firstName"));
        	System.out.println("Last Name: " + (String) patient.patientData.getDataRepo().get("lastName"));
        	System.out.println("Date Of Birth: " + (String) patient.patientData.getDataRepo().get("birthMonth") + "/" + 
        			(String) patient.patientData.getDataRepo().get("birthDay") + "/" + 
        			(String) patient.patientData.getDataRepo().get("birthYear")	
        	);
        	System.out.println("Age: " + (String) patient.patientData.getDataRepo().get("age"));
        	System.out.println("Health Issues: " + (String) patient.patientData.getDataRepo().get("previousHealthIssues"));
        	System.out.println("Immune History: " + (String) patient.patientData.getDataRepo().get("immunizationHistory"));
        	System.out.println("Medications: " + (String) patient.patientData.getDataRepo().get("currentPrescriptions"));
        	System.out.println("Patient ID: " + patient.getPatientID() + "\n");
        });
        
        Text title = new Text("ANTAVA");
    	title.setFont(Font.font("Merriweather", FontWeight.BOLD, 20));
    	title.setStyle("-fx-fill: rgba(170, 103, 29, 0.8);");
    	patientView.getChildren().addAll(newLogo, title, firstNameField, lastNameField, birthDayField, birthMonthField, birthYearField, ageField, healthIssueArea, immuneHistoryArea, currentPrescriptionsArea, logoutButton, confirmButton);
    	
    	
    	return patientScene;
	}
}
