class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] rowArray = grid[i];
                int[] colArray = new int[n];

                for (int k = 0; k < n; k++) {
                    colArray[k] = grid[k][j];
                }

                if (Arrays.equals(rowArray, colArray)) {
                    count++;
                }
            }
        }

        return count;    
    }
}