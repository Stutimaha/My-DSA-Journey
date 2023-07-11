class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int start = 0;
        int end = n-1;
        
        reverse(s, start, end);
    }
    
    public void reverse(char[] s, int start, int end) {
        if(start>=end){
            return;
        }
        
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        reverse(s, start+1,end-1);
        
    }
}