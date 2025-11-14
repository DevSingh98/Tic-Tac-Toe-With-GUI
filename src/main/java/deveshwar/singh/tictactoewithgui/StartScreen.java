package deveshwar.singh.tictactoewithgui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class StartScreen extends Application {
    static Scene scene;
    public static void setScene(Scene scene1) {
        scene=scene1;
    }
    public void start(Stage primaryStage) {
        VBox root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        root.setStyle("-fx-background: linear-gradient(to bottom, #667eea 0%, #764ba2 100%);");
        
        Label title = new Label("TIC TAC TOE");
        title.setStyle("-fx-font-family: 'Arial Black'; -fx-font-size: 48px; -fx-text-fill: white; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 0, 3);");
        
        Button startPVP = createModernButton("👥 Player vs Player", "#4CAF50");
        Button startPVC = createModernButton("🤖 Player vs Computer", "#2196F3");
        
        startPVP.setOnAction(e -> {
            PlayerVsPlayer game = new PlayerVsPlayer();
            game.setMode(0);
            primaryStage.setScene(game.getScene());
        });
        
        startPVC.setOnAction(e -> {
            PlayerVsPlayer game = new PlayerVsPlayer();
            game.setMode(1);
            primaryStage.setScene(game.getScene());
        });
        
        root.getChildren().addAll(title, startPVP, startPVC);
        Scene main = new Scene(root, 600, 500);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(main);
        primaryStage.show();
    }
    
    private Button createModernButton(String text, String color) {
        Button button = new Button(text);
        button.setPrefSize(300, 80);
        button.setStyle(String.format(
            "-fx-background-color: %s; -fx-text-fill: white; -fx-font-size: 18px; " +
            "-fx-font-weight: bold; -fx-background-radius: 25; -fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2);", color));
        
        button.setOnMouseEntered(e -> button.setStyle(String.format(
            "-fx-background-color: derive(%s, -10%%); -fx-text-fill: white; -fx-font-size: 18px; " +
            "-fx-font-weight: bold; -fx-background-radius: 25; -fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 12, 0, 0, 4); -fx-scale-x: 1.05; -fx-scale-y: 1.05;", color)));
        
        button.setOnMouseExited(e -> button.setStyle(String.format(
            "-fx-background-color: %s; -fx-text-fill: white; -fx-font-size: 18px; " +
            "-fx-font-weight: bold; -fx-background-radius: 25; -fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2); -fx-scale-x: 1.0; -fx-scale-y: 1.0;", color)));
        
        return button;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
