class Solution {
    public int minFlips(int[][] mat) {
        if (isZero(mat)) {
            return 0;
        }
        
        int min = -1;
        
        int m = mat.length;
        int n = mat[0].length;
        
        for (int i = 0; i < (1 << (m * n)); i++) {
            int[][] copy = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    copy[r][c] = mat[r][c];
                }
            }
            
            int flips = 0;
            
            for (int j = 0; j < m * n; j++) {
                if ((i & (1 << j)) != 0) {
                    flips++;
                    int r = j / n; 
                    int c = j % n; 
                    flip(copy, r, c); 
                    flip(copy, r - 1, c); 
                    flip(copy, r + 1, c); 
                    flip(copy, r, c - 1); 
                    flip(copy, r, c + 1); 
                }
            }
            
            if (isZero(copy)) {
                if (min == -1 || flips < min) {
                    min = flips;
                }
            }
        }
        
        return min;
    }
    
    private boolean isZero(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                if (val != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void flip(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (r >= 0 && r < m && c >= 0 && c < n) {
            mat[r][c] ^= 1; 
        }
    }
}