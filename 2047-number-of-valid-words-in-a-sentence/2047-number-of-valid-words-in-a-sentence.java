class Solution {
    public int countValidWords(String sentence) {
        if(sentence.length()==0) return 0;

        String[] str = sentence.strip().split("\\s+"); 
        int count = 0;

        for(String s : str){                      
            if(isValid(s))  {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(String s){
        int hyphen = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) return false;      

            if(Character.isLowerCase(ch)) continue;     
            if (ch == '-') {
                if (++hyphen > 1) return false;     
                if (i - 1 < 0 || !Character.isLowerCase(s.charAt(i-1)) || i + 1 >= s.length() || !Character.isLowerCase(s.charAt(i+1))) return false;   
            }
            else if (i != s.length() - 1) return false;    
        }
        return true;   
    }
}