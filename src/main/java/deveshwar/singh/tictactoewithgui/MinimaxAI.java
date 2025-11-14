package deveshwar.singh.tictactoewithgui;

public class MinimaxAI {
    
    public static int[] getBestMove(int[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2; // Computer is player 2
                    int score = minimax(board, 0, false);
                    board[i][j] = 0;
                    
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        return bestMove;
    }
    
    private static int minimax(int[][] board, int depth, boolean isMaximizing) {
        CheckWin checker = new CheckWin(board);
        int result = checker.getWin();
        
        if (result == 2) return 10 - depth; // Computer wins
        if (result == 1) return depth - 10; // Player wins
        if (isBoardFull(board)) return 0; // Draw
        
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2;
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = 0;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = 0;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
    
    private static boolean isBoardFull(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
}