package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PatientView {
	
	public static Scene getScene(Patient patient) {
		// TODO: this is a placeholder
		VBox patientView = new VBox();
		patientView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
		patientView.setAlignment(Pos.CENTER);
		
    	Scene patientScene = new Scene(patientView, 500, 750);
    	patientScene.setFill(Color.rgb(201, 241, 253));
    	
    	ImageView newLogo = new ImageView(Main.logo.getImage());
    	newLogo.setFitWidth(250); 
    	newLogo.setFitHeight(250);
        
        Text title = new Text("ANTAVA");
    	title.setFont(Font.font("Merriweather", FontWeight.BOLD, 20));
    	title.setStyle("-fx-fill: rgba(170, 103, 29, 0.8);");
    	patientView.getChildren().add(newLogo);
    	patientView.getChildren().add(title);
    	
        patientView.getChildren().add(new Text("Successful login. Patient view here."));
    	
    	return patientScene;
	}
}
