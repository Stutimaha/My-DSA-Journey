class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointS = 0;
        int pointT = 0;
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        
        while(pointS<chS.length&& pointT < chT.length){
            if(chT[pointT]==chS[pointS]){
                pointS++;
            }
            pointT++;
        }
        return pointS==chS.length;
    }
}