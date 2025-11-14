package deveshwar.singh.tictactoewithgui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import lombok.extern.java.Log;

@Log
public class PlayerVsPlayer extends StartScreen {
    private int [][] board = new int [3][3];
    private int turn =0;
    private BorderPane boarderPane = new BorderPane();
    private Scene scene;
    private boolean computer = false;
    private boolean hardMode = false;
    boolean[] clicked = new boolean[9];
    private Button PVC = new Button();
    private Button PVP = new Button();
    private Button easyMode = new Button();
    private Button hardModeBtn = new Button();
    private TextArea textBox = new TextArea();
    private final String X = "✕";
    private final String O = "◯";
    private final String playerOneButtonAttribute = "-fx-background-color: linear-gradient(to bottom, #FF6B6B, #FF5252); -fx-text-fill: white; -fx-font-size: 60px; -fx-font-weight: bold; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2);";
    private final String playerTwoButtonAttribute = "-fx-background-color: linear-gradient(to bottom, #4ECDC4, #26A69A); -fx-text-fill: white; -fx-font-size: 60px; -fx-font-weight: bold; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2);";
    private final String activeButton = "-fx-background-color: linear-gradient(to bottom, #4CAF50, #45A049); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 6, 0, 0, 2);";
    private final String nonActiveButton = "-fx-background-color: linear-gradient(to bottom, #9E9E9E, #757575); -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-background-radius: 20; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 4, 0, 0, 1);";

    public void setMode(int x) {
        if(x==0) {
            computer = false;
            PVC.setStyle(nonActiveButton);
            PVP.setStyle(activeButton);
            easyMode.setVisible(false);
            hardModeBtn.setVisible(false);
        }
        if(x==1) {
            computer = true;
            PVP.setStyle(nonActiveButton);
            PVC.setStyle(activeButton);
            easyMode.setVisible(true);
            hardModeBtn.setVisible(true);
            hardMode = false;
            easyMode.setStyle(activeButton);
            hardModeBtn.setStyle(nonActiveButton);
        }
    }


    public PlayerVsPlayer() {
        boarderPane.setStyle("-fx-background: linear-gradient(to bottom, #f7f7f7 0%, #e8e8e8 100%);");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setAlignment(Pos.CENTER);
        
        Label title = new Label("TIC TAC TOE");
        title.setPrefSize(1000, 80);
        title.setStyle("-fx-background-color: linear-gradient(to right, #667eea 0%, #764ba2 100%); " +
                      "-fx-text-fill: white; -fx-font-family: 'Arial Black'; -fx-font-size: 32px; " +
                      "-fx-font-weight: bold; -fx-background-radius: 15; " +
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 8, 0, 0, 2);");
        title.setAlignment(Pos.CENTER);
        boarderPane.setTop(title);
        
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.setPrefWidth(220);
        
        PVP.setPrefSize(180, 50);
        PVP.setText("👥 Player vs Player");
        
        PVC.setPrefSize(180, 50);
        PVC.setText("🤖 vs Computer");
        
        Button restart = new Button("🔄 Restart");
        restart.setPrefSize(180, 50);
        restart.setStyle(nonActiveButton);
        
        textBox.setPrefSize(180, 80);
        textBox.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 10; " +
                        "-fx-background-radius: 10; -fx-font-size: 16px; -fx-font-weight: bold; " +
                        "-fx-text-fill: #333; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 1);");
        textBox.setEditable(false);
        
        easyMode.setPrefSize(180, 40);
        easyMode.setText("🟢 Easy");
        easyMode.setStyle(activeButton);
        easyMode.setVisible(false);
        
        hardModeBtn.setPrefSize(180, 40);
        hardModeBtn.setText("🔴 Hard");
        hardModeBtn.setStyle(nonActiveButton);
        hardModeBtn.setVisible(false);
        
        Button backButton = new Button("🏠 Main Menu");
        backButton.setPrefSize(180, 50);
        backButton.setStyle(nonActiveButton);
        backButton.setOnAction(event -> {
            StartScreen startScreen = new StartScreen();
            try {
                startScreen.start((javafx.stage.Stage) backButton.getScene().getWindow());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        sidebar.getChildren().addAll(PVP, PVC, easyMode, hardModeBtn, restart, backButton, textBox);



        boarderPane.setLeft(sidebar);
        Button[] buttons = new Button[9];

        String defaultButtonStyle = "-fx-background-color: linear-gradient(to bottom, #ffffff, #f0f0f0); " +
                                   "-fx-border-color: #ddd; -fx-border-width: 2; -fx-background-radius: 20; " +
                                   "-fx-border-radius: 20; -fx-font-size: 60px; -fx-font-weight: bold; " +
                                   "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 6, 0, 0, 2);";
        
        String hoverButtonStyle = "-fx-background-color: linear-gradient(to bottom, #f8f8f8, #e8e8e8); " +
                                 "-fx-border-color: #bbb; -fx-border-width: 2; -fx-background-radius: 20; " +
                                 "-fx-border-radius: 20; -fx-font-size: 60px; -fx-font-weight: bold; " +
                                 "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.2), 8, 0, 0, 3);";
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setId(i + "");
            buttons[i].setPrefSize(150, 150);
            buttons[i].setStyle(defaultButtonStyle);
            
            buttons[i].setOnMouseEntered(event -> {
                int id = Integer.parseInt(((Button) event.getSource()).getId());
                if (!clicked[id]) {
                    buttons[id].setStyle(hoverButtonStyle);
                }
            });
            
            buttons[i].setOnMouseExited(event -> {
                int id = Integer.parseInt(((Button) event.getSource()).getId());
                if (!clicked[id]) {
                    buttons[id].setStyle(defaultButtonStyle);
                }
            });
            
            buttons[i].setOnAction(event -> {
                int buttonId = Integer.parseInt(((Button) event.getSource()).getId());
                handleButtonClick(buttons, buttonId);
            });
        }

        // Add buttons to grid
        for (int i = 0; i < 9; i++) {
            grid.add(buttons[i], i % 3, i / 3);
        }

        PVP.setOnAction(event ->{
            resetBoard(buttons);
            computer=false;
            PVP.setStyle(activeButton);
            PVC.setStyle(nonActiveButton);
            easyMode.setVisible(false);
            hardModeBtn.setVisible(false);
            textBox.setText(null);
        });
        PVC.setOnAction(event ->{
            resetBoard(buttons);
            computer=true;
            PVC.setStyle(activeButton);
            PVP.setStyle(nonActiveButton);
            easyMode.setVisible(true);
            hardModeBtn.setVisible(true);
            hardMode = false;
            easyMode.setStyle(activeButton);
            hardModeBtn.setStyle(nonActiveButton);
            textBox.setText(null);
        });
        easyMode.setOnAction(event ->{
            hardMode = false;
            easyMode.setStyle(activeButton);
            hardModeBtn.setStyle(nonActiveButton);
            resetBoard(buttons);
            textBox.setText(null);
        });
        hardModeBtn.setOnAction(event ->{
            hardMode = true;
            hardModeBtn.setStyle(activeButton);
            easyMode.setStyle(nonActiveButton);
            resetBoard(buttons);
            textBox.setText(null);
        });
        restart.setOnAction(event ->{
            resetBoard(buttons);
            textBox.setText(null);
        });

        boarderPane.setCenter(grid);
        scene = new Scene(boarderPane, 1000, 700);

        for(int i=0;i<3;i++) {
            for(int j =0; j< 3; j++ ) {
                board[i][j]=0;
            }
        }

    }
    private void handleButtonClick(Button[] button, int buttonId) {
        int row = buttonId / 3;
        int column = buttonId % 3;
        if(board[row][column] == 0 && turn < 10){
            boolean playerOneTurn = turn % 2 == 0;
            board[row][column] = playerOneTurn ? 1 : 2;
            int buttonNumPlayer = (row) * 3 + column;
            Button b = button[buttonNumPlayer];
            b.setText(playerOneTurn ? X : O);
            b.setStyle(playerOneTurn ? playerOneButtonAttribute : playerTwoButtonAttribute);
            clicked[buttonId] = true;
            turn++;
            if(turn > 4)
                checkWin(board);
            if(computer && turn < 9) {
                int[] move;
                if (hardMode) {
                    move = MinimaxAI.getBestMove(board);
                } else {
                    List<int[]> availableSpots = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i][j] == 0) {
                                availableSpots.add(new int[]{i, j});
                            }
                        }
                    }
                    Random rand = new Random();
                    move = availableSpots.get(rand.nextInt(availableSpots.size()));
                }
                
                int buttonNum = move[0] * 3 + move[1];
                button[buttonNum].setText(O);
                button[buttonNum].setStyle(playerTwoButtonAttribute);
                clicked[buttonNum] = true;
                board[move[0]][move[1]] = 2;
                turn++;
                
                if (turn > 4)
                    checkWin(board);
            }

            printBoard();
        }
    }

    private void buttonReset(Button button){
        String defaultStyle = "-fx-background-color: linear-gradient(to bottom, #ffffff, #f0f0f0); " +
                              "-fx-border-color: #ddd; -fx-border-width: 2; -fx-background-radius: 20; " +
                              "-fx-border-radius: 20; -fx-font-size: 60px; -fx-font-weight: bold; " +
                              "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 6, 0, 0, 2);";
        button.setStyle(defaultStyle);
        button.setText("");
    }

    private void resetBoard(Button[] buttons){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j]=0;
            }
        }
        turn=0;
        for(int i = 0; i < clicked.length; i++){
            clicked[i] = false;
        }
        for(Button b: buttons){
            buttonReset(b);
        }
    }

    Scene getScene() {
        return scene;
    }

    private void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void checkWin(int [][] board){
        CheckWin check = new CheckWin(board);
        final String p1 = "Player 1 wins";
        final String p2 = "Player 2 wins";
        final String draw = "Draw";
        if(check.getWin()==1) {
            turn=10;
            log.info(p1);
            textBox.setText(p1);
        }
        if(check.getWin()==2) {
            turn=10;
            log.info(p2);
            textBox.setText(p2);
        }
        if(turn==9) {
            turn=10;
            log.info(draw);
            textBox.setText(draw);
        }
    }
}
