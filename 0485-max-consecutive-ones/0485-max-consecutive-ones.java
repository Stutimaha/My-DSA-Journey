//max = max count in whole array
//count = just count of consecutive 1s; again 0 if it encounters 0
//if  max<count update max

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int maxConsecutiveOnes = 0;
        
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else {
                int currentConsecutiveOnes = end - start;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
                start = end + 1;
                end++;
            }
        }
        
        int currentConsecutiveOnes = end - start;
        maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
        
        return maxConsecutiveOnes;
    }
}
