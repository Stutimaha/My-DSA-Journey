class Solution {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int numSquares(int n) {
        if (n <= 3) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int minCount = n;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int count = numSquares(n - i * i) + 1;
            if (count < minCount) {
                minCount = count;
            }
        }

        memo.put(n, minCount);
        return minCount;
    }
}


