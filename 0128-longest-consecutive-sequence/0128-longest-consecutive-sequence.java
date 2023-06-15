import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a HashSet to store all the elements in the array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        
        // Iterate over the elements in the array
        for (int num : nums) {
            // Check if the current element is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                // Increment the current number to find consecutive elements
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                // Update the longest streak if necessary
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
}
