package deveshwar.singh.tictactoewithgui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class PlayerVsPlayer extends StartScreen {
    private static int [][] board = new int [3][3];
    private static int turn =0;
    private static BorderPane boarderPane = new BorderPane();
    private static Scene scene;
    private static boolean computer = false;
    private static Button PVC = new Button();
    private static Button PVP = new Button();
    private static TextArea textBox = new TextArea();
    private final String X = "X";
    private final String O = "O";
    private final String playerOneButtonAttribute ="-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;";
    private final String playerTwoButtonAttribute = "-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;";

    public static void setMode(int x) {
        if(x==0) {
            computer = false;
            PVC.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            PVP.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
        }
        if(x==1) {
            computer = true;
            PVP.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            PVC.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
        }
    }


    public PlayerVsPlayer() {

        GridPane grid = new GridPane();
        Label ButtonHolder = new Label(" ");
        Label Title = new Label ("Tic Tac Toe");
        Title.setPrefSize(900, 100);
        Title.setStyle("-fx-background-color: #000000;-fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #FF0000; -fx-font-weight: bold;");
        Title.setAlignment(javafx.geometry.Pos.CENTER); // Center the text
        boarderPane.setBottom(null);//bottom border pane is non existent
        boarderPane.setTop(Title); // leaves top border pane blank
        ButtonHolder.setPrefSize(100, 100);

        VBox v = new VBox();


        PVP.setPrefSize(200,100);
        PVP.setText("Player VS Player");

        PVC.setPrefSize(200,100);
        PVC.setText("Vs Computer");
        Label space = new Label(" ");
        Button restart = new Button();
        restart.setPrefSize(200, 100);
        restart.setText("Restart");
        restart.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");

        Label space2 = new Label(" ");
        Label space3 = new Label(" ");


        HBox h = new HBox();
        textBox.setPrefSize(150, 100);
        h.getChildren().addAll(v,ButtonHolder);
        v.getChildren().addAll(PVP,space,PVC,space2,restart,space3,textBox);



        boarderPane.setLeft(h);//where the menu buttons will go
        Button[] buttons = new Button[9];

        // Initialize buttons and set common properties
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].setId(i+"");
            buttons[i].setPrefSize(200, 200);
            buttons[i].setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
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
            PVP.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            PVC.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            textBox.setText(null);
        });
        PVC.setOnAction(event ->{
            resetBoard(buttons);
            computer=true;
            PVC.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            PVP.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
            textBox.setText(null);
        });
        restart.setOnAction(event ->{
            resetBoard(buttons);
            textBox.setText(null);
        });

        grid.setPrefSize(625, 625);
        boarderPane.setCenter(grid); // sets the center pane with the game grid

        scene =new Scene(boarderPane);

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
            turn++;
            if(turn > 4)
                checkWin(board);
            if(computer && turn < 9) {
                List<int[]> availableSpots = new ArrayList<>();

                // Collect all empty spots
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i][j] == 0) {
                            availableSpots.add(new int[]{i, j});
                        }
                    }
                }

                if (!availableSpots.isEmpty()) {
                    Random rand = new Random();
                    int[] move = availableSpots.get(rand.nextInt(availableSpots.size()));
                    int rand_row = move[0];
                    int rand_col = move[1];

                    int buttonNum = (rand_row) * 3 + rand_col;
                    button[buttonNum].setText(O);
                    button[buttonNum].setStyle(playerTwoButtonAttribute);
                    board[rand_row][rand_col] = 2;
                    turn++;

                    if (turn > 4)
                        checkWin(board);
                }
            }

            printBoard();
        }
    }

    private void buttonReset(Button button){
        button.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
        button.setText("");
    }

    private void resetBoard(Button[] buttons){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j]=0;
            }
        }
        turn=0;
        for(Button b: buttons){
            buttonReset(b);
        }
    }

    static Scene getScene() {
        return scene;
    }

    private static void printBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void checkWin(int [][] board){
        CheckWin check = new CheckWin(board);
        final String p1 = "Player 1 wins";
        final String p2 = "Player 2 wins";
        final String draw = "Draw";
        if(check.getWin()==1) {
            turn=10;
            System.out.println(p1);
            textBox.setText(p1);
        }
        if(check.getWin()==2) {
            turn=10;
            System.out.println(p2);
            textBox.setText(p2);
        }
        if(turn==9) {
            turn=10;
            System.out.println(draw);
            textBox.setText(draw);
        }
    }
}
