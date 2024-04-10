package antava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

public class DoctorView 
{
	public static Scene getScene(Doctor doctor)
	{
		//The main layout container
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20));
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
	        Label lblPatientInfo = new Label("Patient Information");
	        lblPatientInfo.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
	        patientInfoSection.add(lblPatientInfo, 0, 0, 4, 1); //Span across four columns
        
	        //Patient Information: Sub Fields
	        TextField txtPatientID = new TextField();
	        txtPatientID.setPromptText("Patient ID");
	        patientInfoSection.add(txtPatientID, 0, 1);
	        TextField txtName = new TextField();
	        txtName.setPromptText("Patient Name");
	        patientInfoSection.add(txtName, 0, 2); 
	        
	        TextField txtAge = new TextField();
	        txtAge.setPromptText("Patient Age");
	        patientInfoSection.add(txtAge, 0, 3); 
	        
	        TextField txtWeight = new TextField();
	        txtWeight.setPromptText("Weight");
	        patientInfoSection.add(txtWeight, 0, 4); 
	        
	        TextField txtHeight = new TextField();
	        txtHeight.setPromptText("Height");
	        patientInfoSection.add(txtHeight, 1, 2);       
	        
	        TextField txtBodyTemp = new TextField();
	        txtBodyTemp.setPromptText("Body Temperature");
	        patientInfoSection.add(txtBodyTemp, 1, 3); 
        
	        TextField txtBloodPressure = new TextField();
	        txtBloodPressure.setPromptText("Blood Pressure");
	        patientInfoSection.add(txtBloodPressure, 1, 4);
	        
	        TextArea txtPreviousHealthIssues = new TextArea();
	        txtPreviousHealthIssues.setPromptText("Previous Health Issues");
	        txtPreviousHealthIssues.setPrefWidth(400);
	        txtPreviousHealthIssues.setPrefHeight(50);
	        txtPreviousHealthIssues.setMaxHeight(50);
	        patientInfoSection.add(txtPreviousHealthIssues, 2, 2); 
	        
	        TextArea txtPreviousMedication = new TextArea();
	        txtPreviousMedication.setPromptText("Previous Medication");
	        txtPreviousMedication.setPrefWidth(400);
	        txtPreviousMedication.setPrefHeight(50);
	        txtPreviousMedication.setMaxHeight(50);
	        patientInfoSection.add(txtPreviousMedication, 2, 3);
	        
	        TextArea txtImmunizationHistory = new TextArea();
	        txtImmunizationHistory.setPromptText("Immunization History");
	        txtImmunizationHistory.setPrefWidth(400);
	        txtImmunizationHistory.setPrefHeight(50);
	        txtImmunizationHistory.setMaxHeight(50);
	        patientInfoSection.add(txtImmunizationHistory, 2, 4); 
	        
	   //Add Messages Section
	   GridPane messageSection = new GridPane();
	   Label lblMessages = new Label("Messages");
	   lblMessages.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
	   
	   HBox messages = new HBox(25);
       ArrayList<Message> ms = MessageRepo.getTo(doctor.getID());
       for (Message m : ms) {
       	messages.getChildren().add(MessageBar.getNode(m, doctor));
       }
       if (ms.isEmpty()) {
       	messages.getChildren().add(new Text("No messages."));
       }
       
       Button composeButton = new Button("Compose Message");
       composeButton.setOnAction(event -> {
       	Main.setScene(ComposeView.getScene(doctor, null));
       });
	   
	   messageSection.setVgap(10);
	   messageSection.setHgap(10);
	   messageSection.add(lblMessages, 0, 0);
	   messageSection.add(messages, 0, 1);
	   messageSection.add(composeButton, 0, 2);
	        
	   //Physical Exam Section
       GridPane physicalExamSection = new GridPane();
       physicalExamSection.setVgap(10);
       physicalExamSection.setHgap(10);
        
        	Label lblPhysicalExam = new Label("Physical Exam Report");
        	lblPhysicalExam.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        	physicalExamSection.add(lblPhysicalExam, 0, 0, 4, 1); 
        	        
	        //Physical Exam Sub Fields
        	TextField txtHead = new TextField();
	        txtHead.setPromptText("H.E.E.N.N.T.");
	        physicalExamSection.add(txtHead, 0, 1); 
		        
	        TextField txtCardio = new TextField();
	        txtCardio.setPromptText("Cardiovascular");
	        physicalExamSection.add(txtCardio, 0, 2);  
	        
	        TextField txtRespiratory = new TextField();
	        txtRespiratory.setPromptText("Respiratory");
	        physicalExamSection.add(txtRespiratory, 0, 3);  
	        
	        TextField txtGastro = new TextField();
	        txtGastro.setPromptText("Gastrointestinal");
	        physicalExamSection.add(txtGastro, 1, 1);  
	        
	        TextField txtMuscu = new TextField();
	        txtMuscu.setPromptText("Musculoskeletal");
	        physicalExamSection.add(txtMuscu, 1, 2);  
	        
	        TextField txtNeuro = new TextField();
	        txtNeuro.setPromptText("Neurological");
	        physicalExamSection.add(txtNeuro, 1, 3);  
	        
	        TextField txtSkin = new TextField();
	        txtSkin.setPromptText("Skin");
	        physicalExamSection.add(txtSkin, 0, 4);  
	        
	        TextField txtPsychiatric = new TextField();
	        txtPsychiatric.setPromptText("Psychiatric");
	        physicalExamSection.add(txtPsychiatric, 1, 4);  
	        
	        TextArea txtFinal = new TextArea();
	        txtFinal.setPromptText("Final Assessment");
	        txtFinal.setPrefWidth(400);
	        txtFinal.setPrefHeight(100);
	        physicalExamSection.add(txtFinal, 2, 1, 1, 4); 
	        
	        TextArea txtSummary = new TextArea();
	        txtSummary.setPromptText("Summary");
	        txtSummary.setPrefWidth(400);
	        txtSummary.setPrefHeight(100);
	        physicalExamSection.add(txtSummary, 0, 5, 3, 1); 
	        
	                
        // Prescription Order Section
        GridPane prescriptionOrderSection = new GridPane();
        prescriptionOrderSection.setVgap(10);
        prescriptionOrderSection.setHgap(10);
        
        //Order Prescriptions label/section
        Label lblOrderPrescription = new Label("Order Prescription");
        lblOrderPrescription.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        prescriptionOrderSection.add(lblOrderPrescription, 0, 0, 4, 1); 
        
        	//Order Prescription: Subfields
	        TextField txtPrescriptionName = new TextField();
	        txtPrescriptionName.setPromptText("Medication Name");
	        prescriptionOrderSection.add(txtPrescriptionName, 0, 1); 
	
	        TextField txtDosage = new TextField();
	        txtDosage.setPromptText("Dosage");
	        prescriptionOrderSection.add(txtDosage, 0, 2);
	
	        TextField txtDuration = new TextField();
	        txtDuration.setPromptText("Duration");
	        prescriptionOrderSection.add(txtDuration, 1, 1); 
	
	        TextField txtNotes = new TextField();
	        txtNotes.setPromptText("Notes");
	        prescriptionOrderSection.add(txtNotes, 1, 2); 
	
	        Button btnOrder = new Button("Order");
	        Button btnCancel = new Button("Cancel");
	        prescriptionOrderSection.add(btnOrder, 2, 1);
	        prescriptionOrderSection.add(btnCancel, 2, 2); 

        
	    Button btnConfirm = new Button("Confirm");
	    TextField txtVisitDate = new TextField();
	    txtVisitDate.setPromptText("Date Of Visit");
        HBox confirmSection = new HBox(25);
        confirmSection.setAlignment(Pos.BOTTOM_RIGHT);
        confirmSection.setPadding(new Insets(5));
        confirmSection.getChildren().addAll(txtVisitDate, btnConfirm);
	        
	    // Adding all sections to the main layout
        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(patientInfoSection, physicalExamSection, prescriptionOrderSection);
        mainLayout.setTop(header);
        mainLayout.setCenter(centerBox);
        mainLayout.setRight(messageSection);
        mainLayout.setBottom(confirmSection);
        
        
        txtPatientID.textProperty().addListener((observable, oldValue, newValue) -> {
            getPatientInfo(doctor, txtPatientID, txtName, txtAge, txtWeight, txtHeight, txtBodyTemp, txtBloodPressure, 
            			   txtPreviousHealthIssues, txtPreviousMedication, txtImmunizationHistory);
        });
        
        btnCancel.setOnAction(event -> {
        	txtPrescriptionName.setText("");
            txtDosage.setText("");
            txtDuration.setText("");
            txtNotes.setText("");
        });
        
        btnOrder.setOnAction(event -> {
        	String medication = txtPrescriptionName.getText();
        	String patientID = txtPatientID.getText();
    		doctor.setPatient(patientID);
            Patient curPatient = doctor.getPatient();
            if (curPatient != null) {
            	PatientDataRepository patientRepo = curPatient.patientData;
            	patientRepo.editPatientData("prescriptions", "");
            	String prescriptions = (String) patientRepo.getDataRepo().get("prescriptions");
            	if (prescriptions.compareTo("") == 0) {
            		prescriptions = medication;
            	} else {
            		prescriptions = (String) patientRepo.getDataRepo().get("prescriptions") + ", " + medication;
            	}
            	patientRepo.editPatientData("prescriptions", prescriptions);
            	
            	System.out.println("Prescriptions: " + (String) patientRepo.getDataRepo().get("prescriptions"));
            }
            
            txtPrescriptionName.setText("");
            txtDosage.setText("");
            txtDuration.setText("");
            txtNotes.setText("");
            
        });
        
        btnConfirm.setOnAction(event -> {
        	String visitDate = txtVisitDate.getText();
        	String HEENNT = txtHead.getText();
        	String cardio = txtCardio.getText();
        	String resp = txtRespiratory.getText();
            String gastro = txtGastro.getText();
            String muscle = txtMuscu.getText();
            String neuro = txtNeuro.getText();
            String skin = txtSkin.getText();
            String psych = txtPsychiatric.getText();
            String finalAssessment = txtFinal.getText();
            String summary = txtSummary.getText();
        	String patientID = txtPatientID.getText();
    		doctor.setPatient(patientID);
            Patient curPatient = doctor.getPatient();
            if (curPatient != null) {
            	PatientDataRepository patientRepo = curPatient.patientData;
            	patientRepo.editPatientData("visitDate", visitDate);
            	patientRepo.editPatientData("HEENNT", HEENNT);
            	patientRepo.editPatientData("cardio", cardio);
            	patientRepo.editPatientData("resp", resp);
            	patientRepo.editPatientData("gastro", gastro);
            	patientRepo.editPatientData("muscle", muscle);
            	patientRepo.editPatientData("neuro", neuro);
            	patientRepo.editPatientData("skin", skin);
            	patientRepo.editPatientData("psych", psych);
            	patientRepo.editPatientData("finalAssessment", finalAssessment);
            	patientRepo.editPatientData("summary", summary);
	    		String weight = (String) patientRepo.getDataRepo().get("weight");
            	String height = (String) patientRepo.getDataRepo().get("height");
            	String temperature = (String) patientRepo.getDataRepo().get("bodyTemperature");
            	String bloodPressure = (String) patientRepo.getDataRepo().get("bloodPressure");
            	String allergies = (String) patientRepo.getDataRepo().get("allergies");
            	String healthConcerns = (String) patientRepo.getDataRepo().get("healthConcerns");
            	String prescriptions = (String) patientRepo.getDataRepo().get("prescriptions");
            	String name = (String) patientRepo.getDataRepo().get("firstName") + " " + (String) patientRepo.getDataRepo().get("lastName");
            	String DOB = (String) patientRepo.getDataRepo().get("birthMonth") + "/" + 
	            			 (String) patientRepo.getDataRepo().get("birthDay") + "/" + 
	            			 (String)patientRepo.getDataRepo().get("birthYear");
            	String age = (String)patientRepo.getDataRepo().get("age");
        		String phoneNumber = (String)patientRepo.getDataRepo().get("phoneNumber");
        		String email = (String)patientRepo.getDataRepo().get("email");
        		String insurance = (String)patientRepo.getDataRepo().get("insuranceCompany");
        		String pharmacy = (String)patientRepo.getDataRepo().get("pharmacy");
        		String previousHealthIssues = (String)patientRepo.getDataRepo().get("previousHealthIssues");
        		String immunizationHistory = (String)patientRepo.getDataRepo().get("immunizationHistory");
        		String currentPrescriptions = (String)patientRepo.getDataRepo().get("currentPrescriptions");
	    		
        		Visit visit = new Visit(visitDate, temperature, bloodPressure, weight, height, allergies,
        								healthConcerns, HEENNT, gastro, cardio, resp, skin, muscle, 
        								neuro, psych, finalAssessment, summary, prescriptions
				        				);
        		
				ArrayList<Visit> visitHistory = (ArrayList<Visit>) patientRepo.getDataRepo().get("visitHistory");
        		visitHistory.add(visit);
        		patientRepo.editPatientData("visitHistory", visitHistory);
        		
        		String curPrescriptions = (String) patientRepo.getDataRepo().get("currentPrescriptions");
        		
        		if (curPrescriptions.compareTo("") != 0 && prescriptions.compareTo("") != 0) {
        			curPrescriptions = curPrescriptions + ", " + prescriptions;
        			patientRepo.editPatientData("currentPrescriptions", curPrescriptions);
        		} 
        		else if(curPrescriptions.compareTo("") == 0 && prescriptions.compareTo("") != 0) {
        			patientRepo.editPatientData("currentPrescriptions", prescriptions);
        		}
        		patientRepo.editPatientData("prescriptions", "");
        		
        		// Save All Info To Text File
        		try {
        			
        			String patientFileName = patientID + "_PatientInfo.txt";
        			FileWriter patientFile = new FileWriter("src/" + patientFileName);
                	BufferedWriter bufWriter = new BufferedWriter(patientFile);
                	bufWriter.write("Patient UserName: " + doctor.getPatient().getAccount().getUsername() + "\n");
                	bufWriter.write("Patient Password: " + doctor.getPatient().getAccount().getPassword() + "\n");
                	bufWriter.write("Patient ID: " + patientID + "\n");
                	bufWriter.write("Patient Name: " + name + "\n");
                	bufWriter.write("Patient Age: " + age + "\n");
                	bufWriter.write("Patient Birth Day: " + DOB + "\n");
                	bufWriter.write("Patient Email: " + email + "\n");
                	bufWriter.write("Patient Phone Number: " + phoneNumber + "\n");
                	bufWriter.write("Insurance Company: " + insurance + "\n");
                	bufWriter.write("Pharmacy: " + pharmacy + "\n");
                	bufWriter.write("Previous Health Issues: " + previousHealthIssues + "\n");
                	bufWriter.write("Immunization History: " + immunizationHistory + "\n");
                	bufWriter.write("Current Prescriptions: " + currentPrescriptions + "\n\n");
                	
                	for(Visit pVisit: (ArrayList<Visit>) patientRepo.getDataRepo().get("visitHistory")) {
                		bufWriter.write(pVisit.getAllVisitInfo());
            		}

                	bufWriter.close();
                    patientFile.close();
                    System.out.println("Patient Information File Created: " + patientFileName);
                    
                } catch (IOException exception) {
                	System.out.println("Couldn't Create Patient File\n");
                	exception.printStackTrace();
                }
        		
            }
        	
        });
        

        // Scene and Stage setup
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        Scene doctorScene = new Scene(mainLayout, screenWidth, screenHeight);
        return doctorScene;
	}
	
	public static void getPatientInfo(Doctor doctor, TextField txtPatientID, TextField txtName, TextField txtAge,
									  TextField txtWeight, TextField txtHeight, TextField txtBodyTemp, TextField txtBloodPressure, 
									  TextArea txtPreviousHealthIssues, TextArea txtPreviousMedication, TextArea txtImmunizationHistory) {
		
		String patientID = txtPatientID.getText();
		doctor.setPatient(patientID);
        Patient curPatient = doctor.getPatient();
        if (curPatient != null) {
        	PatientDataRepository patientRepo = curPatient.patientData;
        	
        	txtName.setText((String) patientRepo.getDataRepo().get("firstName") + " "  
        	+ (String) patientRepo.getDataRepo().get("lastName"));
        	txtAge.setText((String) patientRepo.getDataRepo().get("age"));
        	txtWeight.setText((String) patientRepo.getDataRepo().get("weight"));
        	txtHeight.setText((String) patientRepo.getDataRepo().get("height"));
        	txtBodyTemp.setText((String) patientRepo.getDataRepo().get("bodyTemperature"));
        	txtBloodPressure.setText((String) patientRepo.getDataRepo().get("bloodPressure"));
        	txtPreviousHealthIssues.setText((String) patientRepo.getDataRepo().get("previousHealthIssues"));
        	txtImmunizationHistory.setText((String) patientRepo.getDataRepo().get("immunizationHistory"));
            txtPreviousMedication.setText((String) patientRepo.getDataRepo().get("currentPrescriptions"));
            doctor.currentPatient = null;
        } else {
        	txtName.setText("");
        	txtAge.setText("");
        	txtWeight.setText("");
        	txtHeight.setText("");
        	txtBodyTemp.setText("");
        	txtBloodPressure.setText("");
        	txtPreviousHealthIssues.setText("");
        	txtImmunizationHistory.setText("");
        	txtPreviousMedication.setText("");
        }
	}
	
}