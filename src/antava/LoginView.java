package antava;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class LoginView {
	
	public static Scene getScene() {
		// LOGIN VIEW
    	VBox loginView = new VBox(10);
    	loginView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	loginView.setAlignment(Pos.CENTER);
    	
    	double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
    	
    	Scene loginScene = new Scene(loginView, screenWidth, screenHeight);
    	loginScene.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	newLogo.setFitWidth(500); 
    	newLogo.setFitHeight(500);
    	Text title = new Text("ANTAVA");
    	title.setFont(Font.font("Merriweather", FontWeight.BOLD, 28));
    	title.setStyle("-fx-fill: rgba(170, 103, 29, 0.8);");
    	loginView.getChildren().add(newLogo);
    	loginView.getChildren().add(title);
    	
    	
    	TextField usernameField = new TextField();
    	usernameField.setPromptText("UserName");
    	usernameField.setPrefWidth(200);
    	usernameField.setMaxWidth(200);
    	loginView.getChildren().add(usernameField);
    	TextField passwordField = new TextField();
    	passwordField.setPromptText("Password");
    	passwordField.setPrefWidth(200);
    	passwordField.setMaxWidth(200);
    	loginView.getChildren().add(passwordField);
        
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
            		Main.setScene(PopupView.getScene("Incorrect username or password.", loginScene));
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
            		Main.setScene(PopupView.getScene("Account successfully created.\nUser ID: " + newPatient.account.getUID(), loginScene, "Proceed to login"));

            	} else {
            		// display an error if there's a duplicate username
                	Main.setScene(PopupView.getScene("An account already exists with that username.", loginScene, "Proceed to login"));

            	}
    		}
    	});
    	
    	return loginScene;
	}

}
