class Solution {
     public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }
    
    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { 
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    
        private boolean isValid(char[][] board, int row, int col, char c){
        int regionRow = 3 * (row / 3);  
        int regionCol = 3 * (col / 3);  
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false; 
            if (board[regionRow + i / 3][regionCol + i % 3] == c) return false;
        }
        return true;
    }
}