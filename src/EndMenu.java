import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndMenu {
	@FXML
	public void onYesPressed() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("hockeyP1.fxml"));
		Scene  scene = new Scene(root);
		scene.getRoot().requestFocus();
		Main.currentStage.setScene(scene);
	}
	@FXML
	public void onNoPressed() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("HockeyMenu.fxml"));
		Scene  scene = new Scene(root);
		scene.getRoot().requestFocus();
		Main.currentStage.setScene(scene);
	}
}
