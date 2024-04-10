package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class DoctorView 
{
	public static Scene getScene(Doctor doctor)
	{
		//The main layout container
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));
        mainLayout.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
        
        // Logo and Log Out Button Section
        StackPane logoPane = new StackPane();
        logoPane.setAlignment(Pos.TOP_CENTER);
        logoPane.setPadding(new Insets(10));

	        ImageView newLogo = new ImageView(Main.logo.getImage());
	        newLogo.setFitWidth(200); 
	        newLogo.setFitHeight(200);
	        logoPane.getChildren().add(newLogo);
	
	        // Log Out Button
	        Button logoutButton = new Button("Log Out");
	        logoutButton.setPadding(new Insets(5));
	        logoutButton.setOnAction(event -> Main.setScene(LoginView.getScene()));
	
        // HBox for the header containing both logo and logout button
        HBox header = new HBox(750);
        header.setAlignment(Pos.CENTER_RIGHT);
        header.setPadding(new Insets(10));
        header.getChildren().addAll(logoPane, logoutButton);
		    
        //Patient Information Section
        GridPane patientInfoSection = new GridPane();
        patientInfoSection.setVgap(10);
        patientInfoSection.setHgap(10);
        
	        //Patient Information label/section
	        Label lblPatientInfo = new Label("Patient Information:");
	        lblPatientInfo.setUnderline(true); //Underline title
	        lblPatientInfo.setFont(Font.font("System", FontWeight.BOLD, 12));
	        patientInfoSection.add(lblPatientInfo, 0, 0, 4, 1); //Span across four columns
        
	        //Patient Information: Sub Fields
	        TextField txtFirstName = new TextField();
	        txtFirstName.setPromptText("Patient Name");
	        patientInfoSection.add(txtFirstName, 0, 1); //Column 0, Row 1
	        
	        TextField txtAge = new TextField();
	        txtAge.setPromptText("Patient Age");
	        patientInfoSection.add(txtAge, 0, 2); //Column 0, Row 2
	        
	        TextField txtWeight = new TextField();
	        txtWeight.setPromptText("Weight");
	        patientInfoSection.add(txtWeight, 0, 3); //Column 0, Row 3
	        
	        TextField txtHeight = new TextField();
	        txtHeight.setPromptText("Height");
	        patientInfoSection.add(txtHeight, 1, 1);  //Column 1, Row 1	        
	        
	        TextField txtBodyTemp = new TextField();
	        txtBodyTemp.setPromptText("Body Temperature");
	        patientInfoSection.add(txtBodyTemp, 1, 2); //Column 1, Row 2
        
	        TextField txtBloodPressure = new TextField();
	        txtBloodPressure.setPromptText("Blood Pressure");
	        patientInfoSection.add(txtBloodPressure, 1, 3); //Column 1, Row 3
	        
	        TextArea txtPreviousHealthIssues = new TextArea();
	        txtPreviousHealthIssues.setPromptText("Previous Health Issues");
	        txtPreviousHealthIssues.setPrefWidth(400);
	        txtPreviousHealthIssues.setPrefHeight(60);
	        txtPreviousHealthIssues.setMaxHeight(60);
	        patientInfoSection.add(txtPreviousHealthIssues, 2, 1); //Column 2, Row 1
	        
	        TextArea txtPreviousMedication = new TextArea();
	        txtPreviousMedication.setPromptText("Previous Medication");
	        txtPreviousMedication.setPrefWidth(400);
	        txtPreviousMedication.setPrefHeight(60);
	        txtPreviousMedication.setMaxHeight(60);
	        patientInfoSection.add(txtPreviousMedication, 2, 2); //Column 2, Row 2
	        
	        TextArea txtImmunizationHistory = new TextArea();
	        txtImmunizationHistory.setPromptText("Immunization History");
	        txtImmunizationHistory.setPrefWidth(400);
	        txtImmunizationHistory.setPrefHeight(60);
	        txtImmunizationHistory.setMaxHeight(60);
	        patientInfoSection.add(txtImmunizationHistory, 2, 3); //Column 2, Row 3
	        
	   //Add Messages Section
	   VBox messageSection = new VBox(10);
	   Label lblMessages = new Label("Messages:");
	   lblMessages.setUnderline(true);
	   lblMessages.setFont(Font.font("System", FontWeight.BOLD, 12));
	   
	   TextArea txtMessage = new TextArea();
	   txtMessage.setPromptText("Receive or Compose Messages");
	   Button btnReply = new Button("Reply");	   
	   messageSection.getChildren().addAll(lblMessages, txtMessage, btnReply);
	        
	   //Physical Exam Section
       GridPane physicalExamSection = new GridPane();
       physicalExamSection.setVgap(10);
       physicalExamSection.setHgap(10);
        
        	Label lblPhysicalExam = new Label("Physical Exam Report:");
        	lblPhysicalExam.setUnderline(true); //Underline title
        	lblPhysicalExam.setFont(Font.font("System", FontWeight.BOLD, 12));
        	physicalExamSection.add(lblPhysicalExam, 0, 0, 4, 1); 
        	        
	        //Physical Exam Sub Fields
        	TextField txtHead = new TextField();
	        txtHead.setPromptText("H.E.E.N.N.T.");
	        physicalExamSection.add(txtHead, 0, 1); //Column 0, Row 1
		        
	        TextField txtCardio = new TextField();
	        txtCardio.setPromptText("Cardiovascular");
	        physicalExamSection.add(txtCardio, 0, 2);  //Column 0, Row 2
	        
	        TextField txtRespiratory = new TextField();
	        txtRespiratory.setPromptText("Respiratory");
	        physicalExamSection.add(txtRespiratory, 0, 3);  //Column 0, Row 3
	        
	        TextField txtGastro = new TextField();
	        txtGastro.setPromptText("Gastrointestinal");
	        physicalExamSection.add(txtGastro, 1, 1);  //Column 1, Row 1
	        
	        TextField txtMuscu = new TextField();
	        txtMuscu.setPromptText("Musculoskeletal");
	        physicalExamSection.add(txtMuscu, 1, 2);  //Column 1, Row 2
	        
	        TextField txtNeuro = new TextField();
	        txtNeuro.setPromptText("Neurological");
	        physicalExamSection.add(txtNeuro, 1, 3);  //Column 1, Row 3
	        
	        TextField txtSkin = new TextField();
	        txtSkin.setPromptText("Skin");
	        physicalExamSection.add(txtSkin, 0, 4);  //Column 0, Row 4
	        
	        TextField txtPsychiatric = new TextField();
	        txtPsychiatric.setPromptText("Psychiatric");
	        physicalExamSection.add(txtPsychiatric, 1, 4);  //Column 1, Row 4
	        
	        TextArea txtFinal = new TextArea();
	        txtFinal.setPromptText("Final Assessment");
	        txtFinal.setPrefWidth(400);
	        txtFinal.setPrefHeight(100);
	        physicalExamSection.add(txtFinal, 2, 1, 1, 4); //Column 2, Row 1
	        
	        TextArea txtSummary = new TextArea();
	        txtSummary.setPromptText("Summary");
	        txtSummary.setPrefWidth(400);
	        txtSummary.setPrefHeight(100);
	        physicalExamSection.add(txtSummary, 0, 5, 3, 1); //Column 0, Row 5
	        
	                
        // Prescription Order Section
        GridPane prescriptionOrderSection = new GridPane();
        prescriptionOrderSection.setVgap(10);
        prescriptionOrderSection.setHgap(10);
        
        //Order Prescriptions label/section
        Label lblOrderPrescription = new Label("Order Prescription:");
        lblOrderPrescription.setUnderline(true); //Underline title
        lblOrderPrescription.setFont(Font.font("System", FontWeight.BOLD, 12));
        prescriptionOrderSection.add(lblOrderPrescription, 0, 0, 4, 1); //Span across four columns
        
        	//Order Prescription: Subfields
	        TextField txtPrescriptionName = new TextField();
	        txtPrescriptionName.setPromptText("Prescription Name");
	        prescriptionOrderSection.add(txtPrescriptionName, 0, 1); // Column 0, Row 1
	
	        TextField txtDosage = new TextField();
	        txtDosage.setPromptText("Dosage");
	        prescriptionOrderSection.add(txtDosage, 0, 2); // Column 0, Row 2
	
	        TextField txtDuration = new TextField();
	        txtDuration.setPromptText("Duration");
	        prescriptionOrderSection.add(txtDuration, 1, 1); // Column 1, Row 1
	
	        TextField txtNotes = new TextField();
	        txtNotes.setPromptText("Notes");
	        prescriptionOrderSection.add(txtNotes, 1, 2); // Column 1, Row 2
	
	        Button btnOrder = new Button("Order");
	        Button btnCancel = new Button("Cancel");
	        prescriptionOrderSection.add(btnOrder, 2, 1); // Column 2, Row 1
	        prescriptionOrderSection.add(btnCancel, 2, 2); // Column 3, Row 2

        HBox patientAndMessageSections = new HBox(400);
        patientAndMessageSections.getChildren().addAll(patientInfoSection, messageSection);
        
	    Button confirmButton = new Button("Confirm");
        HBox confirmSection = new HBox();
        confirmSection.setAlignment(Pos.BOTTOM_RIGHT);
        confirmSection.setPadding(new Insets(5));
        confirmSection.getChildren().add(confirmButton);
        
        //Event Handlers
        
        //Confirm Button
        confirmButton.setOnAction(new EventHandler<ActionEvent>()
        		{
	        		@Override
	        		public void handle(ActionEvent event)
	        		{
	        			//Pull patient information from the patient information text fields
	        			String patientName = txtFirstName.getText();
	        			int patientAge = Integer.parseInt(txtAge.getText());  	 		// Convert age to integer
	        	        double weight = Double.parseDouble(txtWeight.getText()); 		// Convert weight to double
	        	        double height = Double.parseDouble(txtHeight.getText()); 		// Convert height to double
	        	        double bodyTemp = Double.parseDouble(txtBodyTemp.getText()); 	// Convert bodyTemp to double
	        	        String bloodPressure = txtBloodPressure.getText();				// String to represent bloodPressure
	        	        String healthIssues = txtPreviousHealthIssues.getText();		// String to represent health issues
	        	        String medication = txtPreviousMedication.getText();
	        	        String immunization = txtImmunizationHistory.getText();
	        	        
	        	        //Pull Physical Exam Report information
	        	        String HEENNT = txtHead.getText();
	        	        String cardio = txtCardio.getText();
	        	        String respiratory = txtRespiratory.getText();
	        	        String gastro = txtGastro.getText();
	        	        String muscu = txtMuscu.getText();
	        	        String neuro = txtNeuro.getText();
	        	        String skin = txtSkin.getText();
	        	        String psych = txtPsychiatric.getText();
	        	        String final_ = txtFinal.getText();
	        	        String summary = txtSummary.getText();
	        	        
	        	        //Create PatientDataRepo Obj and update patient information
	        	        PatientDataRepository cp = new PatientDataRepository();
	        	        cp.editPatientData("patientName", patientName);
	        	        cp.editPatientData("patientAge", patientAge);
	        	        cp.editPatientData("bodyTemperature", bodyTemp);
	        	        cp.editPatientData("weight", weight);
	        	        cp.editPatientData("height", height);
	        	        cp.editPatientData("bloodPressure", bloodPressure);
	        	        cp.editPatientData("previousHealthConcerns", healthIssues);
	        	        cp.editPatientData("previousMedication", medication);
	        	        cp.editPatientData("immunizationHistory", immunization);
	        	        cp.editPatientData("HEENNT", HEENNT);
	        	        cp.editPatientData("cardiovascular", cardio);
	        	        cp.editPatientData("respiratory", respiratory);
	        	        cp.editPatientData("gastrointestinal", gastro);
	        	        cp.editPatientData("musculoskeletal", muscu);
	        	        cp.editPatientData("neurological", neuro);
	        	        cp.editPatientData("skin", skin);
	        	        cp.editPatientData("psychiatric", psych);
	        	        cp.editPatientData("finalAssessment", final_);
	        	        cp.editPatientData("summary", summary);
	        	        
	        		}
        		});
        
        //Order Prescription Button
        btnOrder.setOnAction(new EventHandler<ActionEvent>()
        		{
	        		@Override
	        		public void handle(ActionEvent event)
	        		{
	        			//Pull prescription information from the Order Prescription text fields
	        			String prescriptionName = txtPrescriptionName.getText();
	        			String dosage = txtDosage.getText();  	 		
	        	        String duration = txtDuration.getText();				
	        	        String notes = txtNotes.getText();
	        	        
	        	        //Create PatientDataRepo Obj and update patient prescription information
	        	        PatientDataRepository cp1 = new PatientDataRepository();
	        	        cp1.editPatientData("prescriptionName", prescriptionName);
	        	        cp1.editPatientData("dosage", dosage);
	        	        cp1.editPatientData("duration", duration);
	        	        cp1.editPatientData("notes", notes);	        	        
	        		}
        		});
        
        //Cancel Prescription Button
        btnCancel.setOnAction(new EventHandler<ActionEvent>()
		{
    		@Override
    		public void handle(ActionEvent event)
    		{
    			//Clear all Order Prescription text fields
    			txtPrescriptionName.setText("");
    			txtDosage.setText("");  	 		
    	        txtDuration.setText("");				
    	        txtNotes.setText("");	        	        
    		}
		});
        
        //Logout Button
        logoutButton.setOnAction(event -> Main.setScene(LoginView.getScene()));       
        
        //Message Reply Button
        btnReply.setOnAction(new EventHandler<ActionEvent>()
		{
    		@Override
    		public void handle(ActionEvent event)
    		{
    			//Get Message from textArea box 
    			String message = txtMessage.getText();
    			
    			//Getting Sender and Receiver UIDs
    			int senderUID = doctor.account.getUID();
    			User user = new User();
    			int receiverUID = user.account.getUID();
    			
    			//Create Message object and send message information
    			Message message_obj = new Message(senderUID, receiverUID, message);
    				        	        
    		}
		});
	        
	    // Adding all sections to the main layout
        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(patientAndMessageSections, physicalExamSection, prescriptionOrderSection);
        mainLayout.setTop(header);
        mainLayout.setCenter(centerBox);
        mainLayout.setBottom(confirmSection);
        

        // Scene and Stage setup
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        Scene doctorScene = new Scene(mainLayout, screenWidth, screenHeight);
        return doctorScene;
	}
	
}