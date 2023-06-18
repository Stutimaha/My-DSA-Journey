class Solution {
    public int majorityElement(int[] nums) {
        int n =  nums.length;
        HashMap<Integer, Integer>map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num)>n/2)  return num;
        }
        return 0;
    }
}