class Solution {
    public int lengthOfLastWord(String s) {
        String[] word = s.split(" ");
        int n = word.length;
        
        int m = word[n-1].length();
        
        return m;
        
    }
}