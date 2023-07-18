class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        placeQueens(board, 0, result);
        return result;
    }
    
    private void placeQueens(char[][] board, int rowIndex, List<List<String>> result){
        if(rowIndex == board.length){
            result.add(construct(board));
            return;
        }
        
        for(int colIndex = 0; colIndex<board.length; colIndex++){
            if(isSafe(board, rowIndex, colIndex)){
                board[rowIndex][colIndex]='Q';
                placeQueens(board, rowIndex+1, result);
                board[rowIndex][colIndex]='.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int rowIndex, int colIndex){
        for (int prevRow = 0; prevRow < rowIndex; prevRow++) {
            if (board[prevRow][colIndex] == 'Q') {
                return false;
            }
        }
        
        for(int i = rowIndex-1, j = colIndex-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }
        
        for(int i = rowIndex-1, j = colIndex+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    
    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
         for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            res.add(row);
        }
        return res;
    }
    
}