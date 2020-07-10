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
	static BorderPane pvp = new BorderPane();
	static Scene scene;
	static boolean computer = false;
	Random ran = new Random();
	
	static Button PVC = new Button();
	static Button NewGame = new Button();
	
	public static void setMode(int x) {
		if(x==0) {
			computer = false;
			PVC.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			NewGame.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
		}
		if(x==1) {
			computer = true;
			NewGame.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			PVC.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
		}
	}
	
	public static int [][] buttonNum = {{1,2,3},{4,5,6},{7,8,9}};
	
	public PlayerVsPlayer() {
		
		GridPane grid = new GridPane();
		Label ButtonHolder = new Label(" ");
		Label Title = new Label ("~~~~~~~~~~~~~~~Tic Tac Toe~~~~~~~~~~~~~~");
		Title.setPrefSize(900, 100);
		Title.setStyle("-fx-background-color: #000000;-fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #FF0000; -fx-font-weight: bold;");
		pvp.setBottom(null);//bottom border pane is non existent 
		pvp.setTop(Title); // leaves top border pane blank
		ButtonHolder.setPrefSize(100, 100);
		
		VBox v = new VBox();
		
		
		NewGame.setPrefSize(200,100);
		NewGame.setText("Player VS Player");
	
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
		TextArea textBox = new TextArea();
		textBox.setPrefSize(150, 100);
		h.getChildren().addAll(v,ButtonHolder);
		v.getChildren().addAll(NewGame,space,PVC,space2,restart,space3,textBox);
		
		
		
		pvp.setLeft(h);//where the menu buttons will go
		
		Button btn1 = new Button();
		Button btn2 = new Button();
		Button btn3 = new Button();
		Button btn4 = new Button();
		Button btn5 = new Button();
		Button btn6 = new Button();
		Button btn7 = new Button();
		Button btn8 = new Button();
		Button btn9 = new Button();
		
		//Button 1 stuff
		grid.add(btn1, 0, 0);
		btn1.setPrefSize(200,200);
		
		btn1.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn1.setOnAction(value ->  {
			if(computer==false) {
				if(board[0][0]==0) {
					if(turn%2==0 && turn < 9) {
			           btn1.setText("X");
			           btn1.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[0][0]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn1.setText("O");
						btn1.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				        board[0][0]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[0][0]!= 0) {
						 btn1.setText("O");
				         btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
					}
					if(board[0][0]==0) {
						if(turn%2==0 && turn < 9) {
				           btn1.setText("X");
				           btn1.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[0][0]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									int temp =turn;
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
				
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			
		});
		
		//Button 2 stuff
		grid.add(btn2, 1, 0);
		btn2.setPrefSize(200,200);
		btn2.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn2.setOnAction(value ->  {
			if(computer == false) {
				if(board[0][1]==0) {
					if(turn%2==0 && turn < 9) {
			           btn2.setText("X");
			           btn2.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[0][1]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn2.setText("O");
						btn2.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
						board[0][1]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[0][1]!= 0) {
						 btn2.setText("O");
				         btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
					}
					if(board[0][1]==0) {
						if(turn%2==0 && turn < 9) {
				           btn2.setText("X");
				           btn2.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[0][1]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			
		});
		
		//Button 3 stuff
		grid.add(btn3, 2, 0);
		btn3.setPrefSize(200,200);
		btn3.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn3.setOnAction(value ->  {
			if(computer == false) {
				if(board[0][2]==0) {
					if(turn%2==0 && turn < 9) {
			           btn3.setText("X");
			           btn3.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");	           
			           board[0][2]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn3.setText("O");
						btn3.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[0][2]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[0][2]==0) {
						if(turn%2==0 && turn < 9) {
				           btn3.setText("X");
				           btn3.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[0][2]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn <8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			
		});
		
		//Button 4 stuff
		grid.add(btn4, 0, 1);
		btn4.setPrefSize(200,200);
		btn4.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn4.setOnAction(value ->  {
			if(computer == false) {
				if(board[1][0]==0) {
					if(turn%2==0 && turn < 9) {
			           btn4.setText("X");
			           btn4.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[1][0]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn4.setText("O");
						btn4.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[1][0]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[1][0]==0) {
						if(turn%2==0 && turn < 9) {
				           btn4.setText("X");
				           btn4.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[1][0]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			
		});
		
		//Button 5 stuff
		grid.add(btn5, 1, 1);
		btn5.setPrefSize(200,200);
		btn5.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn5.setOnAction(value ->  {
			if(computer == false) {
				if(board[1][1]==0) {
					if(turn%2==0 && turn < 9) {
			           btn5.setText("X");
			           btn5.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[1][1]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn5.setText("O");
						btn5.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				        board[1][1]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[1][1]==0) {
						if(turn%2==0 && turn < 9) {
				           btn5.setText("X");
				           btn5.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[1][1]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
		});
		
		//Button 6 stuff
		grid.add(btn6, 2, 1);
		btn6.setPrefSize(200,200);
		btn6.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn6.setOnAction(value ->  {
			if(computer == false) {
				if(board[1][2]==0) {
					if(turn%2==0 && turn < 9) {
			           btn6.setText("X");
			           btn6.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[1][2]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn6.setText("O");
						btn6.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				        board[1][2]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[1][2]==0) {
						if(turn%2==0 && turn < 9) {
				           btn6.setText("X");
				           btn6.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[1][2]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
		});
		
		//Button 7 stuff
		grid.add(btn7, 0, 2);
		btn7.setPrefSize(200,200);
		btn7.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn7.setOnAction(value ->  {
			if(computer == false) {
				if(board[2][0]==0) {
					if(turn%2==0 && turn < 9) {
			           btn7.setText("X");
			           btn7.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");	           
			           board[2][0]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn7.setText("O");
						btn7.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				        board[2][0]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[2][0]==0) {
						if(turn%2==0 && turn < 9) {
				           btn7.setText("X");
				           btn7.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[2][0]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();

		});
		
		//Button 8 stuff
		grid.add(btn8, 1, 2);
		btn8.setPrefSize(200,200);
		btn8.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn8.setOnAction(value ->  {
			if(computer == false) {
				if(board[2][1]==0) {
					if(turn%2==0 && turn < 9) {
			           btn8.setText("X");
			           btn8.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[2][1]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn8.setText("O");
						btn8.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[2][1]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[2][1]==0) {
						if(turn%2==0 && turn < 9) {
				           btn8.setText("X");
				           btn8.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[2][1]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
		});
		
		//Button 9 stuff
		grid.add(btn9, 2, 2);
		btn9.setPrefSize(200,200);
		btn9.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
		btn9.setOnAction(value ->  {
			if(computer == false) {
				if(board[2][2]==0) {
					if(turn%2==0 && turn < 9) {
			           btn9.setText("X");
			           btn9.setStyle("-fx-background-color: #0000FF; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			           board[2][2]=1;
					}
					else if(turn%2 !=0 && turn < 9) {
						btn9.setText("O");
						btn9.setStyle("-fx-background-color: #810541; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[2][2]=2;
					}
					turn++;
				}
			}
			else if(computer==true) {
				if(turn%2==0) {
					if(board[2][2]==0) {
						if(turn%2==0 && turn < 9) {
				           btn9.setText("X");
				           btn9.setStyle("-fx-background-color: #F52887; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           board[2][2]=1;
				           turn++;
				           if(turn >=5) {
								CheckWin check = new CheckWin(board);
								if(check.getWin()==1) {
									turn=10;
									System.out.println("Player 1 wins");
									textBox.setText("Player 1 Wins");
								}
								if(check.getWin()==2) {
									turn=10;
									System.out.println("Player 2 wins");
									textBox.setText("Player 2 Wins");
								}
								if(turn==9) {
									turn=10;
									System.out.println("Draw");
									textBox.setText("Draw");
								}
							}
				           
				           if(turn<8) {
				           int row = ran.nextInt(3);
					       int column = ran.nextInt(3);
					       while(board[row][column]!=0) {
					    	   row=ran.nextInt(3);
					    	   column= ran.nextInt(3);
					        }
					       board[row][column]=2;
				           turn++;
				           System.out.println(turn);
				           int q = buttonNum[row][column];
				           if(q==1) {
				        	   btn1.setText("O");
						       btn1.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==2) {
				        	   btn2.setText("O");
						       btn2.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==3) {
				        	   btn3.setText("O");
						       btn3.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==4) {
				        	   btn4.setText("O");
						       btn4.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==5) {
				        	   btn5.setText("O");
						       btn5.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==6) {
				        	   btn6.setText("O");
						       btn6.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==7) {
				        	   btn7.setText("O");
						       btn7.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;"); 
				           }
				           if(q==8) {
				        	   btn8.setText("O");
						       btn8.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
				           if(q==9) {
				        	   btn9.setText("O");
						       btn9.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-font: 40 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
				           }
						}
						}
					}
				}
			}
				if(turn >=5) {
					CheckWin check = new CheckWin(board);
					if(check.getWin()==1) {
						turn=10;
						System.out.println("Player 1 wins");
						textBox.setText("Player 1 Wins");
					}
					if(check.getWin()==2) {
						turn=10;
						System.out.println("Player 2 wins");
						textBox.setText("Player 2 Wins");
					}
					if(turn==9) {
						turn=10;
						System.out.println("Draw");
						textBox.setText("Draw");
					}
				}
				for(int i=0; i< 3; i++) {
					for(int j=0; j < 3; j++) {
						System.out.print(board[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			
		});
		
	
		NewGame.setOnAction(value ->  {
			for(int i = 0; i<3;i++) {
				for(int j = 0; j<3; j++) {
					board[i][j]=0;
				}
			}
			turn=0;
			btn1.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn1.setText(" ");
			btn2.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn2.setText(" ");
			btn3.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn3.setText(" ");
			btn4.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn4.setText(" ");
			btn5.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn5.setText(" ");
			btn6.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn6.setText(" ");
			btn7.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn7.setText(" ");
			btn8.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn8.setText(" ");
			btn9.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn9.setText(" ");
			
			computer = false;
			PVC.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			NewGame.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			textBox.setText(null);
		});
		

		PVC.setOnAction(value ->{
			for(int i = 0; i<3;i++) {
				for(int j = 0; j<3; j++) {
					board[i][j]=0;
				}
			}
			turn=0;
			btn1.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn1.setText(" ");
			btn2.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn2.setText(" ");
			btn3.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn3.setText(" ");
			btn4.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn4.setText(" ");
			btn5.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn5.setText(" ");
			btn6.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn6.setText(" ");
			btn7.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn7.setText(" ");
			btn8.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn8.setText(" ");
			btn9.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn9.setText(" ");
			
			computer=true;
			PVC.setStyle("-fx-background-color: #FFA500; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			NewGame.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;-fx-background-radius: 50, 50, 50, 50;-fx-font: 15 arial; -fx-text-fill: #000000; -fx-font-weight: bold;");
			textBox.setText(null);
		});
		
		restart.setOnAction(value ->{
			for(int i = 0; i<3;i++) {
				for(int j = 0; j<3; j++) {
					board[i][j]=0;
				}
			}
			turn=0;
			btn1.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn1.setText(" ");
			btn2.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn2.setText(" ");
			btn3.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn3.setText(" ");
			btn4.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn4.setText(" ");
			btn5.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn5.setText(" ");
			btn6.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn6.setText(" ");
			btn7.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn7.setText(" ");
			btn8.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn8.setText(" ");
			btn9.setStyle("-fx-background-color: #00BFFF; -fx-border-color: white;");
			btn9.setText(" ");
			textBox.setText(null);
			
		});
		
		grid.setPrefSize(625, 625);
		pvp.setCenter(grid); // sets the center pane with the game grid
	
		scene =new Scene(pvp);
		
		for(int i=0;i<3;i++) {
			for(int j =0; j< 3; j++ ) {
			board[i][j]=0;
			}
		}
		

		
	}
	
	static Scene getScene() {
		return scene;
	}
}



	

