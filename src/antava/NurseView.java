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

public class NurseView {
	
	public static Scene getScene(Nurse nurse) {
		// TODO: this is a placeholder
		VBox nurseView = new VBox();
		nurseView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
		nurseView.setAlignment(Pos.CENTER);
    	Scene nurseScence = new Scene(nurseView, 500, 750);
    	nurseScence.setFill(Color.rgb(201, 241, 253));
    	ImageView newLogo = new ImageView(Main.logo.getImage());
        Main.ImageDim(newLogo, nurseView.getScene(), 0.8);
        nurseView.getChildren().add(newLogo);
        nurseView.getChildren().add(new Text("Successful login. Nurse view here."));
    	
    	return nurseScence;
	}
}
