class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>(); 
        
        int count = 0;
        
        for (int num : nums) {
            int rem = k - num;
            
            if (freqMap.getOrDefault(rem, 0) > 0) {
                freqMap.put(rem, freqMap.get(rem) - 1);
                count++;
            } else {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }
        
        return count;
    }
}
