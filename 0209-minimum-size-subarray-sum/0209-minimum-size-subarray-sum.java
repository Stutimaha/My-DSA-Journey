class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (end <nums.length){
            sum += nums[end];
            end++;
            
            while(sum>=target){
                minLength = Math.min(end-start, minLength);
                sum -= nums[start];
                start++;
            }            
        }
        if (minLength != Integer.MAX_VALUE) {
                return minLength;
        } 
        else {
                return 0;
        }
    }
}
