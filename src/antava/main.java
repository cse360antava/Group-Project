package antava;

import java.awt.Label;

import java.util.ArrayList;

import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
    	// TODO: This is a blatant hack and should be fixed later on
    	// I couldn't get it to read the image locally,
    	// so this fetches it from the GitHub organization's profile picture
    	ImageView logo = new ImageView();
    	logo.setImage(new Image("https://avatars.githubusercontent.com/u/163464474?s=400&u=863a0130fd7a0f9c4732e287690245896fae7e02&v=4"));
    	
    	// LOGIN VIEW
    	VBox loginView = new VBox();
    	loginView.setAlignment(Pos.CENTER);
    	loginView.getChildren().add(logo);
    	
    	Scene loginScene = new Scene(loginView, 500, 750);
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
            	boolean loginSuccess = false;
            	ArrayList<User> accountListLogin = new ArrayList<User>(userList.values());
            	for (int i = 0; i < accountListLogin.size(); i++) {
            		System.out.println(accountListLogin.get(i).account.getUsername());
            		System.out.println(usernameInput);
            		if (accountListLogin.get(i).account.getUsername() == usernameInput) {
            			System.out.println("hre");
            			loginSuccess = accountListLogin.get(i).account.login(usernameInput, passwordInput);
            			break;
            		}
            	}
            	if (loginSuccess) {
            		VBox patientView = new VBox();
                	patientView.setAlignment(Pos.CENTER);
                	patientView.getChildren().add(logo);
                	patientView.getChildren().add(new Text("Successful login. Patient view here."));
                	Scene patientScene = new Scene(patientView, 500, 750);
                	patientScene.setFill(Color.rgb(201, 241, 253));
                	primaryStage.setScene(patientScene);
            	} else {
            		VBox loginFailedView = new VBox();
                	loginFailedView.setAlignment(Pos.CENTER);
                	loginFailedView.getChildren().add(logo);
                	loginFailedView.getChildren().add(new Text("Incorrect username or password."));
                	Button loginFailedBack = new Button("Back");
                	loginFailedView.getChildren().add(loginFailedBack);
                	loginFailedBack.setOnAction(new EventHandler<ActionEvent>() {
                    	public void handle(ActionEvent event) {
                    		primaryStage.setScene(loginScene);
                    	}
                	});
                	Scene loginFailedScene = new Scene(loginFailedView, 500, 750);
                	loginFailedScene.setFill(Color.rgb(201, 241, 253));
                	primaryStage.setScene(loginFailedScene);
            	}
        	}
        });
    	
    	Button createButton = new Button("Create Account");
    	loginView.getChildren().add(createButton);
    	createButton.setOnAction(new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event) {
    			String createAccountPassword = passwordField.getText();
            	String createAccountUsername = usernameField.getText();
            	// TODO: add the birthday stuff
            	//int createAccountBirthDay = 0; //the birth DAY, ex. 2/1/2001's birth day is 1
            	//int createAccountBirthMonth = 0;
            	//int createAccountBirthYear = 0;
            	boolean alreadyExistingUsername = false;
            	ArrayList<User> accountListRegister = new ArrayList<User>(userList.values());
            	for (int i = 0; i < accountListRegister.size(); i++) {
            		if (accountListRegister.get(i).account.getUsername() == createAccountUsername) {
            			alreadyExistingUsername = true;
            			//account with same username already created
            			break;
            		}
            	}
            	if (!alreadyExistingUsername) { //if username is unique, create the account
            		Patient newPatient = new Patient(new Account(createAccountUsername, createAccountPassword, "patient"));
        			userList.put(newPatient.account.getUID(), newPatient);
        			
        			VBox createView = new VBox();
                	createView.setAlignment(Pos.CENTER);
                	createView.getChildren().add(logo);
                	createView.getChildren().add(new Text("Successfully created."));
                	Button createBack = new Button("Proceed to login");
                	createView.getChildren().add(createBack);
                	createBack.setOnAction(new EventHandler<ActionEvent>() {
                    	public void handle(ActionEvent event) {
                    		primaryStage.setScene(loginScene);
                    	}
                	});
                	Scene createScene = new Scene(createView, 500, 750);
                	createScene.setFill(Color.rgb(201, 241, 253));
                	primaryStage.setScene(createScene);
            	} else {
            		VBox createFailedView = new VBox();
                	createFailedView.setAlignment(Pos.CENTER);
                	createFailedView.getChildren().add(logo);
                	createFailedView.getChildren().add(new Text("An account already exists with that username."));
                	Button createFailedBack = new Button("Back");
                	createFailedView.getChildren().add(createFailedBack);
                	createFailedBack.setOnAction(new EventHandler<ActionEvent>() {
                    	public void handle(ActionEvent event) {
                    		primaryStage.setScene(loginScene);
                    	}
                	});
                	Scene createFailedScene = new Scene(createFailedView, 500, 750);
                	createFailedScene.setFill(Color.rgb(201, 241, 253));
                	primaryStage.setScene(createFailedScene);
            	}
    		}
    	});
    	
    	
    	//TODO: Doctor view: on pressing the doctor view button, go to the doctor view
    	//TODO: Nurse view: on pressing the nurse view, go to the nurse view
    	
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
    
    
}