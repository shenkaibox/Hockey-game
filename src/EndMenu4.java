import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndMenu4 {
	@FXML
	public void onYesPressed4() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("hockeyP2.fxml"));
		Scene  scene = new Scene(root);
		scene.getRoot().requestFocus();
		Main.currentStage.setScene(scene);
	}
	@FXML
	public void onNoPressed4() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("HockeyMenu.fxml"));
		Scene  scene = new Scene(root);
		scene.getRoot().requestFocus();
		Main.currentStage.setScene(scene);
	}
}
