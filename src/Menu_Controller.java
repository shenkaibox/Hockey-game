import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu_Controller {

	@FXML
	public void onStartPressedP1() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("hockeyP1.fxml"));
		Scene  P1Scene = new Scene(root);
		P1Scene.getRoot().requestFocus();
		Main.currentStage.setScene(P1Scene);
	}
	@FXML
	public void onStartPressedP2() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("hockeyP2.fxml"));
		Scene  P2Scene = new Scene(root);
		P2Scene.getRoot().requestFocus();
		Main.currentStage.setScene(P2Scene);
	}
	
	@FXML
	public void onExitPressed() {
		Main.currentStage.close();
	}

}
