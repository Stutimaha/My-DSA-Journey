class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        
        for(char ch : s.toCharArray()){
            if(ch=='*'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
        if(st.isEmpty()){
            return res;
        }
        else{
            while(!st.isEmpty()){
                res = st.pop() + res;
            }
        }
        return res;
    }
}