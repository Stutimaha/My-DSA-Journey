class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] copy = Arrays.copyOf(nums, nums.length);
    Arrays.sort(copy);
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = copy[left] + copy[right];
        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            break;
        }
    }
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == copy[left]) {
            result[0] = i;
            break;
        }
    }
    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] == copy[right]) {
            result[1] = i;
            break;
        }
    }
    return result;
}
}
