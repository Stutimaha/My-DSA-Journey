class Solution {
    public int subsetXORSum(int[] nums) {        
        int[] xorSum = {0}; 
        backtrack(nums, 0, 0, xorSum);
        return xorSum[0];
    }
    
    private void backtrack(int[] nums, int index, int currentXOR, int[] xorSum){
        if (index == nums.length) {
            xorSum[0] += currentXOR; 
            return;
        }
        
        backtrack(nums, index + 1, currentXOR, xorSum);
        
        currentXOR ^= nums[index]; 
        backtrack(nums, index + 1, currentXOR, xorSum);        
    }
}
