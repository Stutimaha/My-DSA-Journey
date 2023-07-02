class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        
        while (i < nums.length) {
            j = i + 1;
            
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                
                if (j < nums.length) {
                    swap(nums, i, j);
                }
            }
            
            i++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
