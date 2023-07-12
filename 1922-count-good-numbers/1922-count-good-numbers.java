public class Solution {
    private static final int MOD = 1000000007;
    
    public int countGoodNumbers(long n) {
        long result = fastModularExponentiation(5, (n + 1) / 2) * fastModularExponentiation(4, n / 2);
        return (int) (result % MOD);
    }
    
    private long fastModularExponentiation(long base, long exponent) {
        long result = 1;
        
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            
            base = (base * base) % MOD;
            exponent /= 2;
        }
        
        return result;
    }
}
