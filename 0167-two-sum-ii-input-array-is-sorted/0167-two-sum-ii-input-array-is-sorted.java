class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        
        for (int left = 0; left < n; left++) {
            int remaining = target - numbers[left];
            int right = n - 1;
            
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                
                if (sum == target) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}