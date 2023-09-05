class Solution {
    public int totalNQueens(int n) {
        int[] queens = new int[n]; 
        Arrays.fill(queens, -1); 
        return solveNQueens(n, queens, 0);
    }

    private int solveNQueens(int n, int[] queens, int row) {
        if (row == n) {
            return 1; 
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                count += solveNQueens(n, queens, row + 1);
                queens[row] = -1; 
            }
        }

        return count;
    }

    private boolean isValid(int[] queens, int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queens[prevRow];

            if (prevCol == col || prevCol - prevRow == col - row || prevCol + prevRow == col + row) {
                return false;
            }
        }

        return true;
    }
}
