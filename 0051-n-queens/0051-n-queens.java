public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        placeQueens(board, 0, res);
        
        return res;
    }
    
    private void placeQueens(char[][] board, int rowIndex, List<List<String>> res) {
        // Base case: If all queens are placed successfully, add the current configuration to the result
        if (rowIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        // Try placing a queen in each column of the current row
        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isSafe(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';  // Place the queen
                
                // Recursively try placing the queens in the next row
                placeQueens(board, rowIndex + 1, res);
                
                board[rowIndex][colIndex] = '.';  // Remove the queen to backtrack and explore other possibilities
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        // Check if there is a queen in the same column or in any of the previous rows
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (board[prevRow][col] == 'Q') {
                return false;
            }
        }
        
        // Check if there is a queen in the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check if there is a queen in the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;  // It is safe to place a queen at the given position
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            res.add(row);
        }
        
        return res;
    }
}
