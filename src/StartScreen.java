import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class StartScreen extends Application {
	static Scene scene;
	public static void setScene(Scene scene1) {
		scene=scene1;
	}
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Label Title = new Label(" Tic Tac Toe");
		Title.setStyle("-fx-background-color: #000000;-fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #FF0000; -fx-font-weight: bold;");
		Title.setPrefSize(250, 100);
		root.setRight(null);
		root.setLeft(null);
		root.setTop(Title);
		Button startPVP = new Button();
		startPVP.setStyle("-fx-background-color: #2C3539;-fx-border-color: white;-fx-font: 16 arial; -fx-text-fill: #736AFF; -fx-font-weight: bold;");
		Button startPVC = new Button();
		startPVC.setStyle("-fx-background-color: #2C3539;-fx-border-color: white;-fx-font: 16 arial; -fx-text-fill: #736AFF; -fx-font-weight: bold;");
		Label space = new Label(" ");
		
		VBox v = new VBox();
		v.getChildren().addAll(startPVP,space,startPVC);
		
		startPVP.setText("Player\n   VS\nPlayer");
		startPVP.setPrefSize(150, 125);
		startPVP.setOnAction(value ->  {
		PlayerVsPlayer a = new PlayerVsPlayer();
		a.setMode(0);
		scene=a.getScene();
		primaryStage.setScene(scene);
		primaryStage.show();	
		});
		
		root.setCenter(v);
		
		
		startPVC.setText("Player\n   VS\nComputer");
		startPVC.setPrefSize(150, 125);
		startPVC.setOnAction(value ->  {
		PlayerVsPlayer a = new PlayerVsPlayer();
		a.setMode(1);
		scene=a.getScene();
		primaryStage.setScene(scene);
		primaryStage.show();		
		});
		Scene Main = new Scene(root);
		
		
		primaryStage.setScene(Main);
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

