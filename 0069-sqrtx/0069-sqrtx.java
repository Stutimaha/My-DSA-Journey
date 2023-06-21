class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        long start = 1;
        long end = x;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return (int) end; 
    }
}
