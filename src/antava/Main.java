package antava;

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
    	
    	//TODO: Doctor view: on pressing the doctor view button, go to the doctor view
    	//TODO: Nurse view: on pressing the nurse view, go to the nurse view
    	
    	// Add default nurse account
        Nurse defaultNurse = new Nurse(new Account("nurse", "nurse321", "nurse"));
        Main.userList.put(defaultNurse.getAccount().getUID(), defaultNurse);

        // Add default doctor account
        Doctor defaultDoctor = new Doctor(new Account("doctor", "doctor321", "doctor"));
        Main.userList.put(defaultDoctor.getAccount().getUID(), defaultDoctor);
        
    	logo = new ImageView(new Image("file:src/antava/logo.jpg"));
        setScene(LoginView.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	launch(args);
    	
    	// the logo should be readily accessible to all the Views,
    	// since all of them use it
    	// TODO: This is a blatant hack and should be fixed later on
    	// I couldn't get it to read the image locally,
    	// so this fetches it from the GitHub organization's profile picture
    	//logo = new ImageView(new Image("https://avatars.githubusercontent.com/u/163464474?s=400&u=863a0130fd7a0f9c4732e287690245896fae7e02&v=4"));
    }
    
    
}
