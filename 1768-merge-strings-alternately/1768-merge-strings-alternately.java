class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        
        while(i<m || i<n){
            if(i<m){
                result = result.concat(Character.toString(word1.charAt(i)));
            }
            if(i<n){
                result = result.concat(Character.toString(word2.charAt(i)));
            }
            i++;
        }
        return result;
    }
}