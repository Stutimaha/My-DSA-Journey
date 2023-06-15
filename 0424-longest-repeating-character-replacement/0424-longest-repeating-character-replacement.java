class Solution {
    public int characterReplacement(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        HashMap<Character, Integer > map = new HashMap<>();
        int left=0;
        int maxCount = 0; 
        int result =0;
        
        for (int right = left; right<n;right++){
            map.put(c[right], map.getOrDefault(c[right],0)+1);
            maxCount = Math.max(maxCount, map.get(c[right]));
            
            int replaceCount = right - left + 1 - maxCount;
            
            if (replaceCount > k) {
                map.put(c[left], map.get(c[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}
