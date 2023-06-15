class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] ch  = s.toCharArray();
        int length = 1;
        int maxlength = 0;
        int left = 0;
        int right = 0;
        
        HashSet<Character> set = new HashSet<>();
        
        while(right<n){
            if (set.contains(ch[right])){
                set.remove(ch[left]);
                left++;
            }
            else  {
                set.add(ch[right]);
                length = right - left +1;
                maxlength = Math.max(length, maxlength);
                right++;
            }
        }
        return maxlength;        
    }
}