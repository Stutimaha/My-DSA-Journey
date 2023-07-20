class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int row = 0; row<9;row++){
            for(int col = 0; col<9;col++){
                if(board[row][col] == '.'){
                    for(char num = '1'; num<='9';num++){
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidPlacement(char[][] board, int row, int col, char num){
        for(int i = 0; i<9; i++){
            if(board[row][i]==num || board[i][col]==num){
                return false;
            }
        }
        
        //check square
        int startRow = 3 * (row/3);
        int startCol = 3 * (col/3);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false; 
                }
            }
        }
        return true;
    }
}