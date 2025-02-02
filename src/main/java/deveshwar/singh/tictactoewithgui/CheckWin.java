package deveshwar.singh.tictactoewithgui;

public class CheckWin  {

    private static int [][] board1 = new int [3][3];

    public CheckWin() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board1[i][j]=0;
            }
        }
    }
    public CheckWin(int[][] board) {
        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                board1[i][j] = board[i][j];
            }
        }

    }

    public int getWin() {

        if((board1[0][0]!=0 && board1[0][1] != 0 && board1[0][2] != 0) && (board1[0][0]==board1[0][1]&& board1[0][1]==board1[0][2])) {// row 1 test
            if(board1[0][0]==1)
                return 1;
            if(board1[0][0]==2)
                return 2;
        }
        if((board1[1][0]!=0 && board1[1][1] != 0 && board1[1][2] != 0) && (board1[1][0]==board1[1][1]&& board1[1][1]==board1[1][2])) { // row 2 test
            if(board1[1][0]==1)
                return 1;
            if(board1[1][0]==2)
                return 2;
        }
        if((board1[2][0]!=0 && board1[2][1] != 0 && board1[2][2] != 0) && (board1[2][0]==board1[2][1]&& board1[2][1]==board1[2][2])) { // row 3 test
            if(board1[2][0]==1)
                return 1;
            if(board1[2][0]==2)
                return 2;
        }


        if((board1[0][0]!=0 && board1[1][1] != 0 && board1[2][2] != 0) && (board1[0][0]==board1[1][1]&& board1[1][1]==board1[2][2])) { // diagonal test
            if(board1[0][0]==1)
                return 1;
            if(board1[0][0]==2)
                return 2;
        }

        if((board1[2][0]!=0 && board1[1][1] != 0 && board1[0][2] != 0) && (board1[2][0]==board1[1][1]&& board1[1][1]==board1[0][2])) {// diagonal test
            if(board1[2][0]==1)
                return 1;
            if(board1[2][0]==2)
                return 2;
        }

        if((board1[0][0]!=0 && board1[1][0] != 0 && board1[2][0] != 0) && (board1[0][0]==board1[1][0]&& board1[1][0]==board1[2][0])) {// column 1 test
            if(board1[0][0]==1)
                return 1;
            if(board1[0][0]==2)
                return 2;
        }
        if((board1[0][1]!=0 && board1[1][1] != 0 && board1[2][1] != 0) && (board1[0][1]==board1[1][1]&& board1[1][1]==board1[2][1])) {// column 2 test
            if(board1[0][1]==1)
                return 1;
            if(board1[0][1]==2)
                return 2;
        }
        if((board1[0][2]!=0 && board1[1][2] != 0 && board1[2][2] != 0) && (board1[0][2]==board1[1][2]&& board1[1][2]==board1[2][2])) {// column 3 test
            if(board1[0][2]==1)
                return 1;
            if(board1[0][2]==2)
                return 2;
        }

        return 0;
    }

}
