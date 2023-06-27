class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int pivot = -1;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        pivot = start;
        
        start = 0;
        end = n - 1;
        
        if(target > nums[end]){
            end = pivot - 1;
        }
        else{
            start = pivot;
        }
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; 
    }
}
