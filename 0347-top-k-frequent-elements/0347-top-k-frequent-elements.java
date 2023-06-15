class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] frequencyLists = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (frequencyLists[frequency] == null) {
                frequencyLists[frequency] = new ArrayList<>();
            }
            frequencyLists[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = frequencyLists.length - 1; i >= 0 && index < k; i--) {
            if (frequencyLists[i] != null) {
                for (int num : frequencyLists[i]) {
                    result[index++] = num;                    
                }
            }
        }
        return result;
    }
}