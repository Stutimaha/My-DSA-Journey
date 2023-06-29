class Solution {
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        
        int start = 0;
        while(start<ch.length){
            if(!st.isEmpty() && st.peek()==ch[start]){
                st.pop();
            }
            else{
                st.push(ch[start]);
            }
            start++;
        }
        
        
        String str = "";
        while(!st.isEmpty()){
            str = st.pop() + str;
        } 
        return str;
    }
}