class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minArray = new int[n];
        minArray[0] = nums[0];

        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] > stack.peek()) {
                if (stack.pop() > minArray[j]) {
                    return true;
                }
            }
            stack.push(nums[j]);
        }

        return false;
    }
}