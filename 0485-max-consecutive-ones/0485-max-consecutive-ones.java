//max = max count in whole array
//count = just count of consecutive 1s; again 0 if it encounters 0
//if  max<count update max

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) count++;
            else count =0;
            max = Math.max(max,count);            
        }
        return max;
    }
}