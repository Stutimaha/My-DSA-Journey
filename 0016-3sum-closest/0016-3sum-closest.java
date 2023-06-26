class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        int n = nums.length;
        
        for(int i = 0;i<n-2;i++){
            int left = i + 1;
            int right = n - 1;
            
            while(left<right){
                int sum = nums[i]+nums[right]+nums[left];
                
                if(sum==target){
                    return target;
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
                if(Math.abs(sum-target)<Math.abs(closestSum-target)){
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
}