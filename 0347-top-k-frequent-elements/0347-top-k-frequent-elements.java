class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        ArrayList<Integer> count = new ArrayList<>(map.values());
        
        Collections.sort(count, Collections.reverseOrder());
        
        int[]  result = new int[k];
        int i = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count.indexOf(entry.getValue()) < k) {
                result[i] = entry.getKey();
                i++;
            }
        }
        return result;
    }
}