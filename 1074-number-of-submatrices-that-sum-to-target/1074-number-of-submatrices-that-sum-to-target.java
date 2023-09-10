class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        int[][] prefixSum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        for (int r1 = 1; r1 <= rows; r1++) {
            for (int r2 = r1; r2 <= rows; r2++) {
                Map<Integer, Integer> prefixSumCount = new HashMap<>();
                prefixSumCount.put(0, 1);

                for (int col = 1; col <= cols; col++) {
                    int sum = prefixSum[r2][col] - prefixSum[r1 - 1][col];
                    if (prefixSumCount.containsKey(sum - target)) {
                        count += prefixSumCount.get(sum - target);
                    }

                    prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
