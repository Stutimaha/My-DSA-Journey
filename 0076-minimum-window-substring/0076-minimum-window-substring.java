class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        String result = "";
        
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        
        if(n>m){
            return result;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : chT){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int left = 0;
        int right = 0;
        int length  = 0;
        int count = map.size();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right<m){
            if(map.containsKey(chS[right])){
                map.put(chS[right], map.get(chS[right])-1);
                if(map.get(chS[right])==0){
                    count--;
                }
            }
            right++;
            
            while(count==0){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                if(map.containsKey(chS[left])){
                    map.put(chS[left], map.get(chS[left])+1);
                    if(map.get(chS[left])>0){
                        count++;
                    }
                }
                left++;
            }
            
        }
        
        if (minLen != Integer.MAX_VALUE) {
            result = s.substring(start, start + minLen);
        }
        
        return result;
    }
}