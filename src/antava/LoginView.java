package antava;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LoginView {
	
	public static Scene getScene() {
		// LOGIN VIEW
    	VBox loginView = new VBox();
    	loginView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	loginView.setAlignment(Pos.CENTER);
    	loginView.getChildren().add(Main.logo);
    	
    	Scene loginScene = new Scene(loginView, 500, 750);
    	//loginScene.setFill(Color.rgb(201, 241, 253));
    	loginScene.setFill(Color.rgb(201, 241, 253));

    	TextField usernameField = new TextField("User ID");
    	loginView.getChildren().add(usernameField);
    	TextField passwordField = new TextField("Password");
    	loginView.getChildren().add(passwordField);
    	
    	Button loginButton = new Button("Login");
    	loginView.getChildren().add(loginButton);
    	loginButton.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
            	String usernameInput = usernameField.getText();
            	String passwordInput = passwordField.getText();
            	// loop through the users to find matching username
            	boolean loginSuccess = false;
            	ArrayList<User> accountListLogin = new ArrayList<User>(Main.userList.values());
            	for (int i = 0; i < accountListLogin.size(); i++) {
            		// once we find a match, attempt login
            		if (accountListLogin.get(i).account.getUsername().equals(usernameInput)) {
            			loginSuccess = accountListLogin.get(i).account.login(usernameInput, passwordInput);
            			break;
            		}
            	}
            	if (loginSuccess) {
            		// if the login is successful, go to the patient view
            		VBox patientView = new VBox();
            		patientView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
                	patientView.setAlignment(Pos.CENTER);
                	patientView.getChildren().add(Main.logo);
                	patientView.getChildren().add(new Text("Successful login. Patient view here."));
                	Scene patientScene = new Scene(patientView, 500, 750);
                	patientScene.setFill(Color.rgb(201, 241, 253));
                	Main.setScene(patientScene);
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
