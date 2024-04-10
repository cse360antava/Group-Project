package antava;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.scene.image.ImageView; 

public class PopupView {
    
    public static Scene getScene(String message, Scene back, String backMessage) { 
        VBox messageView = new VBox(10);
        messageView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
        messageView.setAlignment(Pos.CENTER);
        
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth() - 100;
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight() - 100;
        
        Scene messageScene = new Scene(messageView, screenWidth, screenHeight);
        messageScene.setFill(Color.rgb(201, 241, 253));
        
        ImageView newLogo = new ImageView(Main.logo.getImage());
        newLogo.setFitWidth(200); 
    	newLogo.setFitHeight(200);
    	
        messageView.getChildren().add(newLogo);
        
        messageView.getChildren().add(new Text(message));
        if (back != null) {
            Button messageBack = new Button(backMessage);
            messageView.getChildren().add(messageBack);
            messageBack.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    Main.setScene(back);
                }
            });
        }
        
        return messageScene;
    }
    
    public static Scene getScene(String message, Scene back) { 
        return getScene(message, back, "Back");
    }
    
    public static Scene getScene(String message) { 
        return getScene(message, null);
    }
    
    public static Scene getScene() { 
        return getScene("Error", null);
    }
}
