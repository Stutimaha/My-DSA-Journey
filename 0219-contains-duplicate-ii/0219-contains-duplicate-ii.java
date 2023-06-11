class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true; // Found a duplicate within the given range
            }
            
            map.put(num, i); 
            
        }
        return false;
    }
}