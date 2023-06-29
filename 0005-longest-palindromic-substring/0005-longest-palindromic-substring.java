class Solution {
    int maxLen = 0;
    int start=0;
    
    public String longestPalindrome(String s) {
        String res = "";
       
        if (s.length() < 2)	return s;
        
        for(int i = 0; i<s.length();i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s,i,i+1);
        }
        return s.substring(start, start+maxLen);
    }
    
    public void extendPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        if (maxLen< right- left-1){
            start = left+1;
            maxLen = right-left-1;
        }
    }
}