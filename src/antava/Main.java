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
    	
    	
    }
    
    
}