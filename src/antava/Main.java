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
    	
        primaryStage.setScene(LoginView.getScene());
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