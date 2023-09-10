class Solution {
    public int countOrders(int n) {
        long MOD = 1000000007;
        long count = 1;

        for (int i = 2; i <= n; i++) {
            long choices = (2 * i - 1) * i;

            count = (count * choices) % MOD;
        }

        return (int) count;
    }
}