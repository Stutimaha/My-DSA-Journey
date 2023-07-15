class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        List<Character> list = new ArrayList<>();
        for(char ch: str.toCharArray()){
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                list.add(ch);
            }
        }
        return check(list,0,list.size()-1);
    }
    
    public boolean check(List<Character> list, int s, int e) {
        if(s==e || s>e){
            return true;
        }
        if(list.get(s)==list.get(e)){
            return check(list, s+1, e-1);
        }
        return false;        
    }
}