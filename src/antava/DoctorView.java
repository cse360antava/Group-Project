package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
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
        mainLayout.setPadding(new Insets(10));
        mainLayout.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));

        //Header with the company logo 
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(10, 10, 20, 10)); // Add padding to the top, right, bottom, and left
        Label lblLogo = new Label("ANTAVA");
        header.getChildren().addAll(lblLogo);
        
	        //Working on implementing logo
        	
        	//Load Logo Image
	        /*ImageView newLogo = new ImageView(Main.logo.getImage());
	        newLogo.setFitWidth(250); 
	    	newLogo.setFitHeight(250);
	        GridPane.setHalignment(newLogo, javafx.geometry.HPos.CENTER);*/
	        
	        /*Image logoImage = new Image(getClass().getResourceAsStream("/logo.jpg"));
	        ImageView logoView = new ImageView(logoImage);
	        logoView.setFitHeight(50);
	        logoView.setPreserveRatio(true);*/
	        //header.getChildren().addAll(logoView);

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
	        
	        TextField txtPreviousHealthIssues = new TextField();
	        txtPreviousHealthIssues.setPromptText("Previous Health Issues");
	        patientInfoSection.add(txtPreviousHealthIssues, 2, 1); //Column 2, Row 1
	        
	        TextField txtPreviousMedication = new TextField();
	        txtPreviousMedication.setPromptText("Previous Medication");
	        patientInfoSection.add(txtPreviousMedication, 2, 2); //Column 2, Row 2
	        
	        TextField txtImmunizationHistory = new TextField();
	        txtImmunizationHistory.setPromptText("Immunization History");
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
	        physicalExamSection.add(txtSkin, 2, 1);  //Column 2, Row 1
	        
	        TextField txtPsychiatric = new TextField();
	        txtPsychiatric.setPromptText("Psychiatric");
	        physicalExamSection.add(txtPsychiatric, 2, 2);  //Column 2, Row 2
	        
	        TextField txtFinal = new TextField();
	        txtFinal.setPromptText("Final Assessment");
	        physicalExamSection.add(txtFinal, 2, 3);  //Column 2, Row 3
	        
	        TextArea txtSummary = new TextArea();
	        txtSummary.setPromptText("Summary");
	        physicalExamSection.add(txtSummary, 0, 4, 3, 1);
	        
	                
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

        HBox patientAndMessageSections = new HBox(20);
        patientAndMessageSections.getChildren().addAll(patientInfoSection, messageSection);
	        
	    // Adding all sections to the main layout
        VBox centerBox = new VBox(20);
        centerBox.getChildren().addAll(patientAndMessageSections, physicalExamSection, prescriptionOrderSection);
        mainLayout.setTop(header);
        mainLayout.setCenter(centerBox);

        // Scene and Stage setup
        Scene doctorScene = new Scene(mainLayout, 850, 600);
        
        return doctorScene;
	}
	
}
