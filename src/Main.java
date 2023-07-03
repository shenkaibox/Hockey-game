import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	public static Stage currentStage;
	public static Scene menuScene;
	public static Scene winend;
	public static Scene Loseend;
	public static Scene Twopalyer_p1win;
	public static Scene Twopalyer_p2win;
	@Override
	public void start(Stage primaryStage) throws Exception{
		currentStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("HockeyMenu.fxml"));
		Parent root2 = FXMLLoader.load(getClass().getResource("Winending.fxml"));
		Parent root3 = FXMLLoader.load(getClass().getResource("Loseending.fxml"));
		Parent root4 = FXMLLoader.load(getClass().getResource("twoplayer_P1win.fxml"));
		Parent root5 = FXMLLoader.load(getClass().getResource("twoplayer_P2win.fxml"));
		menuScene = new Scene(root);
		winend = new Scene(root2);
		Loseend = new Scene(root3);
		Twopalyer_p1win = new Scene(root4);
		Twopalyer_p2win = new Scene(root5);
		currentStage.setTitle("Hcokey");
		currentStage.setScene(menuScene);
		currentStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
