class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return backtrack(0, 0, m, n, grid);
    }

    private int backtrack(int row, int col, int m, int n, int[][] grid) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }

        if (grid[row][col] == 0) {
            int rightPaths = backtrack(row, col + 1, m, n, grid);
            int downPaths = backtrack(row + 1, col, m, n, grid);
            grid[row][col] = rightPaths + downPaths; 
        }

        return grid[row][col];
    }
}


