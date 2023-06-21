class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int windowSize = 2 * k + 1;
        
        long windowSum = 0;
        int[] result = new int[n];
        Arrays.fill(result,-1);

        if (n < windowSize) {
            return result;
        }

        for (int i = 0; i < n; ++i) {
            windowSum += nums[i]; // Add nums[i] to the window sum

            if (i - windowSize >= 0) {
                windowSum -= nums[i - windowSize]; // Remove nums[i - windowSize] from the window sum
            }

            if (i >= windowSize - 1) {
                result[i - k] = (int) (windowSum / windowSize); // Calculate and store the average in the result
            }
        }

        return result;
    }
}