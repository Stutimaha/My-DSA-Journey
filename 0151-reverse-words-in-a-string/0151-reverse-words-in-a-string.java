class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        
        String result = "";
        
        Stack<String> stack = new Stack<>();
        
        for(String word : words){
            stack.push(word);
        }
        
        while(!stack.isEmpty()){
           result = result.concat(stack.pop().concat(" "));
        }
        result = result.trim();
        return result;
    }
}