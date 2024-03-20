package antava;

import java.util.ArrayList;

import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 
public class main extends Application {

	public static boolean loggedIn = false;
	public static HashMap<Integer, User> userList = new HashMap<Integer, User>(); //UID to user hashmap
	
    public void start(Stage primaryStage) {
    	ImageView logo = new ImageView();
    	//logo.setImage(new Image("logo.jpg"));
    	
    	// LOGIN VIEW
    	VBox loginView = new VBox();
    	loginView.getChildren().add(logo);
    	
    	//Create new account code section: link this block to the press of the create account button
    	String createAccountPassword = ""; //Use this variable for the password of the new account
    	String createAccountUsername = ""; //Use this variable for the username of the new account
    	// TODO: add the birthday stuff
    	//int createAccountBirthDay = 0; //the birth DAY, ex. 2/1/2001's birth day is 1
    	//int createAccountBirthMonth = 0;
    	//int createAccountBirthYear = 0;
    	boolean alreadyExistingUsername = false;
    	ArrayList<User> accountListRegister = new ArrayList<User>(userList.values());
    	for (int i = 0; i < accountListRegister.size(); i++) {
    		if (accountListRegister.get(i).account.getUsername() == createAccountUsername) {
    			alreadyExistingUsername = true;
    			//account with same username already created error
    			break;
    		}
    	}
    	if (!alreadyExistingUsername) { //if username is unique, create the account
    		Patient newPatient = new Patient(new Account(createAccountUsername, createAccountPassword, "patient"));
			userList.put(newPatient.account.getUID(), newPatient);
    	}
    	
    	//Login section: link this to the press of the login button
    	String usernameInput = ""; //use this variable for the login username
    	String passwordInput = ""; //use this variable for the login password
    	boolean loginSuccess = false;
    	ArrayList<User> accountListLogin = new ArrayList<User>(userList.values());
    	for (int i = 0; i < accountListLogin.size(); i++) {
    		if (accountListLogin.get(i).account.getUsername() == usernameInput) {
    			loginSuccess = accountListLogin.get(i).account.login(usernameInput, passwordInput);
    			break;
    		}
    	}
    	if (loginSuccess) {
    		//show patient view
    	} else {
    		//show failed login
    	}
    	
    	//TODO: Doctor view: on pressing the doctor view button, go to the doctor view
    	//TODO: Nurse view: on pressing the nurse view, go to the nurse view
    	
    	/*
    	 * The code below should be at the end, change the primary stage size as necessary
    	 * I kind of just reused Carter's asuHelloWorldJFX code, so if you want to rename
    	 * go ahead
    	 */
    	
        primaryStage.setScene(new Scene(loginView, 700, 350));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
    
    
}