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
import javafx.scene.text.Text;

public class DoctorView {
	
	public static Scene getScene(Doctor doctor) {
		// TODO: this is a placeholder
		VBox doctorView = new VBox();
		doctorView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
		doctorView.setAlignment(Pos.CENTER);
    	Scene doctorScene = new Scene(doctorView, 500, 750);
    	doctorScene.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
        Main.ImageDim(newLogo, doctorView.getScene(), 0.4);
        doctorView.getChildren().add(newLogo);
        doctorView.getChildren().add(new Text("Successful login. Doctor view here."));
    	
    	return doctorScene;
	}
}
