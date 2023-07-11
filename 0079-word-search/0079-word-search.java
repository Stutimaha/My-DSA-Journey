class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        
        for(int r = 0; r<rows; r++){
          for(int c = 0; c<cols; c++){
                if (character(board, ch, r, c, 0)){
                    return true;
                }
            }  
        }
        return false;
    }
    
    public boolean character(char[][] board, char[] ch, int r, int c, int index){
        if(index==ch.length){
            return true;
        }
           
        int rows = board.length;
        int cols = board[0].length;
        
        if(r<0 || r>=rows || c<0 || c>=cols || board[r][c]!=ch[index]){
            return false;
        } 
        
        board[r][c] = '#';
        
        boolean found = character(board, ch, r+1, c, index+1) || character(board, ch, r-1, c, index+1) || character(board, ch, r, c+1, index+1) || character(board, ch, r, c-1, index+1);
        
        board[r][c] = ch[index];
        
        return found;
    }
}
