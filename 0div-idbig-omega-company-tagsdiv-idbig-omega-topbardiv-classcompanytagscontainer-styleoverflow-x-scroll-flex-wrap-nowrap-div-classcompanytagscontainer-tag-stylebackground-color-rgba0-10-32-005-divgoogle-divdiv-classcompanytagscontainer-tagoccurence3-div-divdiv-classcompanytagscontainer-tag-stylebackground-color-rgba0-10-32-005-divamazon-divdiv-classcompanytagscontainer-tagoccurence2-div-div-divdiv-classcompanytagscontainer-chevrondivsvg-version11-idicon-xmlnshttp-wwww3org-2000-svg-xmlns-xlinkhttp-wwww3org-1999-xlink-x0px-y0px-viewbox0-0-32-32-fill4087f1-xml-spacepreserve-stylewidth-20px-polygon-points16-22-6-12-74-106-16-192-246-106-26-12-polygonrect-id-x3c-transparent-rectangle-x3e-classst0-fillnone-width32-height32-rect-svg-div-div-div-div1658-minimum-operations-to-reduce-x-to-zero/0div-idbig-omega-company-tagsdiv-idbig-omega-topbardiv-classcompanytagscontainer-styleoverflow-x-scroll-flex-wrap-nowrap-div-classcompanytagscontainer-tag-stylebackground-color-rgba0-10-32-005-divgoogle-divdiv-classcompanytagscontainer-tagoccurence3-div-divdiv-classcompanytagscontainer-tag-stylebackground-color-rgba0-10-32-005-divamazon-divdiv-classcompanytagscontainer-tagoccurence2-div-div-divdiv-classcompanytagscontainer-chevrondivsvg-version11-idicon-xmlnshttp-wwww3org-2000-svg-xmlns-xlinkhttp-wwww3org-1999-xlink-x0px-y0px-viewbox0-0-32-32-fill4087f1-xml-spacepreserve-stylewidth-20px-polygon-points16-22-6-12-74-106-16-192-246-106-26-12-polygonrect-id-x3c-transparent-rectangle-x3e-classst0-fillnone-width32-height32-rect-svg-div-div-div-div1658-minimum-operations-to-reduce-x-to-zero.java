class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int targetSum = Arrays.stream(nums).sum() - x;

        if (targetSum < 0) {
            return -1;
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            while (currentSum > targetSum) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == targetSum) {
                minLength = Math.min(minLength, n - (right - left + 1));
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}