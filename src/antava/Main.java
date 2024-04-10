package antava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
 
public class Main extends Application {

	public static boolean loggedIn = false;
	public static HashMap<Integer, User> userList = new HashMap<Integer, User>(); //UID to user hashmap
	
	public static Stage s; // singleton stage
	
	public static ImageView logo;
	
	// sets the stage, used for switching between views
	public static void setScene(Scene scene) {
		s.setScene(scene);
	}
	
    public void start(Stage primaryStage) {
    	s = primaryStage; // initialize the singleton
    	
    	// NOTE: because of how UIDs are generated, they start at 1
    	// Add default nurse account
        Nurse defaultNurse = new Nurse(new Account("nurse", "nurse321", "nurse"));
        Main.userList.put(defaultNurse.getAccount().getUID(), defaultNurse);

        // Add default doctor account
        Doctor defaultDoctor = new Doctor(new Account("doctor", "doctor321", "doctor"));
        Main.userList.put(defaultDoctor.getAccount().getUID(), defaultDoctor);
        
        // Read Files and loads in patient accounts and information
    	readPatientInfoFiles();
        
    	logo = new ImageView(new Image("file:src/antava/logo.jpg"));
        setScene(LoginView.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
    
    private void readPatientInfoFiles() {
        File folder = new File("src/");
        File[] fileList = folder.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                if (file.isFile() && file.getName().endsWith("_PatientInfo.txt")) {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        String line;
                        String username = null;
                        String password = null;
                        String patientID = null;
                        PatientDataRepository patientDataRepository = new PatientDataRepository();

                        // Read username, password, patientID and all patient information from file
                        while ((line = br.readLine()) != null) {
                            if (line.startsWith("Patient UserName:")) {
                                username = line.substring(line.indexOf(":") + 2);
                            } else if (line.startsWith("Patient Password:")) {
                                password = line.substring(line.indexOf(":") + 2);
                            } else if (line.startsWith("Patient ID:")) {
                                patientID = line.substring(line.indexOf(":") + 2);
                                patientDataRepository.editPatientData("patientID", patientID);
                            } else if (line.startsWith("Patient Name")) {
                                String[] patientName = line.substring(line.indexOf(":") + 2).split(" ");
                                patientDataRepository.editPatientData("firstName", patientName[0]);
                                patientDataRepository.editPatientData("lastName", patientName[1]);
                            } else if (line.startsWith("Patient Birth Day:")) {
                                String[] dobParts = line.substring(line.indexOf(":") + 2).split("/");
                                patientDataRepository.editPatientData("birthDay", dobParts[0]);
                                patientDataRepository.editPatientData("birthMonth", dobParts[1]);
                                patientDataRepository.editPatientData("birthYear", dobParts[2]);
                            } else if (line.startsWith("Patient Age:")) {
                                patientDataRepository.editPatientData("age", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Patient Phone Number:")) {
                                patientDataRepository.editPatientData("phoneNumber", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Patient Email:")) {
                                patientDataRepository.editPatientData("email", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Insurance Company:")) {
                            	patientDataRepository.editPatientData("insuranceCompany", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Pharmacy:")) {
                            	patientDataRepository.editPatientData("pharmacy", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Previous Health Issues:")) {
                                patientDataRepository.editPatientData("previousHealthIssues", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Immunization History:")) {
                                patientDataRepository.editPatientData("immunizationHistory", line.substring(line.indexOf(":") + 2));
                            } else if (line.startsWith("Current Prescriptions:")) {
                                patientDataRepository.editPatientData("currentPrescriptions", line.substring(line.indexOf(":") + 2));
                            } else if (line.trim().isEmpty()) {
                                break; 
                            }
                        }

                        if (username != null && password != null && patientID != null) {
                            // Create a patient account
                            Account patientAccount = new Account(username, password, "patient");                            
                            
                            while ((line = br.readLine()) != null) {	
                            	if (line.startsWith("Date Of Visit:")) {
                                    String visitDate = line.substring(line.indexOf(":") + 2);

                                    // Read and store information for the current visit
                                    String temperature = br.readLine().substring("Temperature: ".length());
                                    String bloodPressure = br.readLine().substring("Blood Pressure: ".length());
                                    String weight = br.readLine().substring("Weight: ".length());
                                    String height = br.readLine().substring("Height: ".length());
                                    String allergies = br.readLine().substring("Allergies: ".length());
                                    String healthConcerns = br.readLine().substring("Health Concerns: ".length());
                                    String HEENNT = br.readLine().substring("HEENNT: ".length());
                                    String gastro = br.readLine().substring("Gastrointestinal: ".length());
                                    String cardio = br.readLine().substring("Cardiovascular: ".length());
                                    String resp = br.readLine().substring("Respiratory: ".length());
                                    String skin = br.readLine().substring("Skin: ".length());
                                    String muscle = br.readLine().substring("Musculoskeletal: ".length());
                                    String neuro = br.readLine().substring("Neurological: ".length());
                                    String psych = br.readLine().substring("Psychiatric: ".length());
                                    String finalAssessment = br.readLine().substring("Final Assessment: ".length());
                                    String summary = br.readLine().substring("Summary: ".length());
                                    String prescriptions = br.readLine().substring("Medication Prescribed: ".length());

                                    // Create a Visit object with the extracted information
                                    Visit visit = new Visit(visitDate, temperature, bloodPressure, weight, height,
                                            allergies, healthConcerns, HEENNT, gastro, cardio, resp, skin, muscle, neuro,
                                            psych, finalAssessment, summary, prescriptions);

                                    // Add the visit to the patient data repository
                                    ArrayList<Visit> visitHistory = (ArrayList<Visit>) patientDataRepository.getDataRepo().get("visitHistory");
                            		visitHistory.add(visit);
                            		patientDataRepository.editPatientData("visitHistory", visitHistory);
                                }
                            }

                            // Create a patient and add it to the userList
                            Patient patient = new Patient(patientAccount);
                            patient.patientData = patientDataRepository;
                            patient.setPatientID(patientID);
                            Main.userList.put(patientAccount.getUID(), patient);
                            System.out.println("Patient account loaded: " + username + " " + password);
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    
}