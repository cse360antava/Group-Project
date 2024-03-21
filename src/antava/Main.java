package antava;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {

	public static boolean loggedIn = false;
	public static HashMap<Integer, User> userList = new HashMap<Integer, User>(); //UID to user hashmap
	
	public static Stage s; // singleton stage
	
	public static ImageView logo;
	
	// sets the stage, used for switching between views
	public static void setStage(Scene scene) {
		s.setScene(scene);
	}
	
    public void start(Stage primaryStage) {
    	s = primaryStage; // initialize the singleton
    	
    	// LOGIN VIEW
    	VBox loginView = new VBox();
    	loginView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	loginView.setAlignment(Pos.CENTER);
    	loginView.getChildren().add(logo);
    	
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
            	ArrayList<User> accountListLogin = new ArrayList<User>(userList.values());
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
                	patientView.getChildren().add(logo);
                	patientView.getChildren().add(new Text("Successful login. Patient view here."));
                	Scene patientScene = new Scene(patientView, 500, 750);
                	patientScene.setFill(Color.rgb(201, 241, 253));
                	primaryStage.setScene(patientScene);
            	} else {
            		// if unsuccessful, show an error message
            		VBox loginFailedView = new VBox();
            		loginFailedView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
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
            	// loop through existing users to make sure there isn't a duplicate username
            	boolean alreadyExistingUsername = false;
            	ArrayList<User> accountListRegister = new ArrayList<User>(userList.values());
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
        			userList.put(newPatient.account.getUID(), newPatient);
        			
        			// show a success message
        			VBox createView = new VBox();
        			createView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
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
            		// display an error if there's a duplicate username
            		VBox createFailedView = new VBox();
            		createFailedView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
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
    	
    	// the logo should be readily accessible to all the Views,
    	// since all of them use it
    	// TODO: This is a blatant hack and should be fixed later on
    	// I couldn't get it to read the image locally,
    	// so this fetches it from the GitHub organization's profile picture
    	ImageView logo = new ImageView();
    	logo.setImage(new Image("https://avatars.githubusercontent.com/u/163464474?s=400&u=863a0130fd7a0f9c4732e287690245896fae7e02&v=4"));
    }
    
    
}