class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        
        int left = 0;
        int  right = n-1;
        
        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('a');
        set.add('E');
        set.add('e');
        set.add('I');
        set.add('i');
        set.add('O');
        set.add('o');
        set.add('U');
        set.add('u');
        
        
        while(left<right){
            if(set.contains(ch[left])&&set.contains(ch[right]) ){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
           else if(!set.contains(ch[right])){
                right--;
            }
            else if(!set.contains(ch[left])){
            left++;
            }            
        }
        return new String(ch);
    }
}