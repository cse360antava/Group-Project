package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PatientView {
	
	public static Scene getScene(Patient patient) {
		// TODO: this is a placeholder
		VBox patientView = new VBox();
		patientView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
    	patientView.setAlignment(Pos.CENTER);
    	patientView.getChildren().add(Main.logo);
    	patientView.getChildren().add(new Text("Successful login. Patient view here."));
    	Scene patientScene = new Scene(patientView, 500, 750);
    	patientScene.setFill(Color.rgb(201, 241, 253));
    	
    	return patientScene;
	}

}
