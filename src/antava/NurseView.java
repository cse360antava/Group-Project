package antava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NurseView {
	
	public static Scene getScene(Nurse nurse) {
		
		GridPane nurseView = new GridPane();
        nurseView.setBackground(new Background(new BackgroundFill(Color.rgb(201, 241, 253), CornerRadii.EMPTY, Insets.EMPTY)));
        nurseView.setAlignment(Pos.TOP_CENTER);
        nurseView.setPadding(new Insets(20));
        nurseView.setHgap(10);
        nurseView.setVgap(10);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        nurseView.getColumnConstraints().addAll(col1, col2);
        
        for (int i = 0; i < 8; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(12.5);
            nurseView.getRowConstraints().add(row);
        }
        
        Text title = new Text("ANTAVA");
        title.setFont(Font.font("Merriweather", FontWeight.BOLD, 20));
        title.setFill(Color.rgb(170, 103, 29, 0.8));
        nurseView.add(title, 0, 0, 2, 1);
        
        
        ImageView newLogo = new ImageView(Main.logo.getImage());
        Main.ImageDim(newLogo, nurseView.getScene(), 0.2);
        nurseView.add(newLogo, 0, 1, 1, 1);
        
        Button logoutButton = new Button("Logout");
        nurseView.add(logoutButton, 1, 1, 1, 1);
        
        Text patientInfoTitle = new Text("Patient Information Section");
        nurseView.add(patientInfoTitle, 0, 2, 1, 1);

        Text vitalsTitle = new Text("Vitals Section");
        nurseView.add(vitalsTitle, 1, 2, 1, 1);

        Text allergiesTitle = new Text("Allergies Section");
        nurseView.add(allergiesTitle, 0, 3, 1, 1);

        Text messagesTitle = new Text("Messages Section");
        nurseView.add(messagesTitle, 1, 3, 1, 1);

        Text healthConcernsTitle = new Text("Health Concerns Section");
        nurseView.add(healthConcernsTitle, 0, 4, 1, 1);

        Button confirmButton = new Button("Confirm");
        nurseView.add(confirmButton, 1, 7, 1, 1);

        Scene nurseScene = new Scene(nurseView, 500, 750);
        return nurseScene;
           
	}
}
