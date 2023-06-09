class Solution {
    public int findMin(int[] nums) {
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
        
        int answer = nums[pivot];    
        return answer;
    }
}