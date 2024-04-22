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
	public static HashMap<Integer, User> userList;
	
	public static Stage s; // singleton stage
	
	public static ImageView logo;
	
	// sets the stage, used for switching between views
	public static void setScene(Scene scene) {
		s.setScene(scene);
	}
	
    public void start(Stage primaryStage) {
    	s = primaryStage; // initialize the singleton
        
    	logo = new ImageView(new Image("file:src/antava/logo.jpg"));
        setScene(LoginView.getScene());
        primaryStage.show();
    }
    
    public static void main(String[] args) {
    	UserList.init();
    	userList = UserList.userList;
    	launch(args);
    }
    
    
    
    
}