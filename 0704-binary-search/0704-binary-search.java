class Solution {
    public int search(int[] nums, int target) {
        return answer(nums, target, 0, nums.length-1);
    }    
    
    public int answer(int[] nums, int target, int start, int end) {
        
        if(start>end){
            return -1;
        }
        
        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return mid;
        }
        if(nums[mid]>target){          
            return  answer(nums, target, start, mid-1);
        }
        return answer(nums, target, mid+1, end);
    }
}
