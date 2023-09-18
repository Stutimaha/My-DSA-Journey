class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        List<int[]> rows = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }
            rows.add(new int[]{i, count});
        }
        
        Collections.sort(rows, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rows.get(i)[0];
        }
        
        return result;
    }
}
