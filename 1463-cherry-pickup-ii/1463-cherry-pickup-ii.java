class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][][] DP = new int[rows][cols][cols];
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    int currentCherries = grid[i][j];
                    
                    if (j != k) {
                        currentCherries += grid[i][k];
                    }
                    
                    if (i != rows - 1) {
                        int maxCherries = 0;
                        
                        for (int move1 = -1; move1 <= 1; move1++) {
                            int newJ1 = j + move1;
                            
                            if (newJ1 >= 0 && newJ1 < cols) {
                                for (int move2 = -1; move2 <= 1; move2++) {
                                    int newK1 = k + move2;
                                    
                                    if (newK1 >= 0 && newK1 < cols) {
                                        maxCherries = Math.max(maxCherries, DP[i + 1][newJ1][newK1]);
                                    }
                                }
                            }
                        }
                        
                        currentCherries += maxCherries;
                    }
                    
                    DP[i][j][k] = currentCherries;
                }
            }
        }
        
        return DP[0][0][cols - 1];
    }
}
