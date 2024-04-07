package antava;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LoginView {
	
	public static Scene getScene() {
		// LOGIN VIEW
    	VBox loginView = new VBox();
    	loginView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	loginView.setAlignment(Pos.CENTER);
    	    	
    	Scene loginScene = new Scene(loginView, 500, 750);
    	loginScene.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	Main.ImageDim(newLogo, loginScene, 0.8);
    	loginView.getChildren().add(newLogo);
    	
    	TextField usernameField = new TextField("User ID");
    	loginView.getChildren().add(usernameField);
    	TextField passwordField = new TextField("Password");
    	loginView.getChildren().add(passwordField);
    	
    	 // Add default nurse account
        Nurse defaultNurse = new Nurse(new Account("nurse", "nurse321", "nurse"));
        Main.userList.put(defaultNurse.getAccount().getUID(), defaultNurse);

        // Add default doctor account
        Doctor defaultDoctor = new Doctor(new Account("doctor", "doctor321", "doctor"));
        Main.userList.put(defaultDoctor.getAccount().getUID(), defaultDoctor);
        
    	Button loginButton = new Button("Login");
    	loginView.getChildren().add(loginButton);
    	loginButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
            	String usernameInput = usernameField.getText();
            	String passwordInput = passwordField.getText();
            	// loop through the users to find matching username
            	boolean loginSuccess = false;
            	User user = null;
            	ArrayList<User> accountListLogin = new ArrayList<User>(Main.userList.values());
            	for (int i = 0; i < accountListLogin.size(); i++) {
            		// once we find a match, attempt login
            		user = accountListLogin.get(i);
            		if (user.account.getUsername().equals(usernameInput)) {
            			loginSuccess = accountListLogin.get(i).account.login(usernameInput, passwordInput);
            			break;
            		}
            	}
            	if (loginSuccess) {
            		// if the login is successful, go to the relevant view
            		switch (user.account.getAccountType()) {
            		case "patient":
            			Main.setScene(PatientView.getScene((Patient)user));
            			break;
            		case "doctor":
            			Main.setScene(DoctorView.getScene((Doctor)user));
            			break;
            		case "nurse":
            			Main.setScene(NurseView.getScene((Nurse)user));
            			break;
            		}
            	} else {
            		// if unsuccessful, show an error message
            		Main.setScene(MessageView.getScene("Incorrect username or password.", loginScene));
            	}
        	}
        });
    	
    	Button createButton = new Button("Create Account");
    	loginView.getChildren().add(createButton);
    	createButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			String createAccountPassword = passwordField.getText();
            	String createAccountUsername = usernameField.getText();
            	// loop through existing users to make sure there isn't a duplicate username
            	boolean alreadyExistingUsername = false;
            	ArrayList<User> accountListRegister = new ArrayList<User>(Main.userList.values());
            	for (int i = 0; i < accountListRegister.size(); i++) {
            		if (accountListRegister.get(i).account.getUsername().equals(createAccountUsername)) {
            			alreadyExistingUsername = true;
            			//account with same username already created
            			break;
            		}
            	}
            	if (!alreadyExistingUsername) {
            		// if username is unique, create the account
            		Patient newPatient = new Patient(new Account(createAccountUsername, createAccountPassword, "patient"));
        			Main.userList.put(newPatient.account.getUID(), newPatient);
        			
        			// show a success message
            		Main.setScene(MessageView.getScene("Account successfully created.\nUser ID: " + newPatient.account.getUID(), loginScene, "Proceed to login"));

            	} else {
            		// display an error if there's a duplicate username
                	Main.setScene(MessageView.getScene("An account already exists with that username.", loginScene, "Proceed to login"));

            	}
    		}
    	});
    	
    	return loginScene;
	}

}
