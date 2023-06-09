class Solution {
    public int minimumDeletions(int[] A) {
        int i = 0, j = 0, n = A.length;
        for (int k = 0; k < n; ++k) {
            if (A[i] < A[k]) i = k;
            if (A[j] > A[k]) j = k;
        }
        return Math.min(Math.min(Math.max(i + 1, j + 1), Math.max(n - i, n - j)), Math.min(i + 1 + n - j, j + 1 + n - i));
    }
}
