class Solution {
    private static final int[][] DIRECTIONS = {
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
            {1, -2}, {2, -1}, {2, 1}, {1, 2}
    };

    public double knightProbability(int n, int k, int row, int column) {
        Map<String, Double> memo = new HashMap<>();
        return backtrack(n, k, row, column, memo);
    }

    private double backtrack(int n, int k, int row, int column, Map<String, Double> memo) {
        if (!isValid(n, row, column))
            return 0.0;

        if (k == 0)
            return 1.0;

        String key = row + "-" + column + "-" + k;

        if (memo.containsKey(key))
            return memo.get(key);

        double probability = 0.0;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            probability += 0.125 * backtrack(n, k - 1, newRow, newCol, memo);
        }

        memo.put(key, probability);

        return probability;
    }

    private boolean isValid(int n, int row, int column) {
        return row >= 0 && row < n && column >= 0 && column < n;
    }
}


    

    