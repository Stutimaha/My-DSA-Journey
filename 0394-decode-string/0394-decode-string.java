import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                
                stack.pop();
                
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numStr.insert(0, stack.pop());
                }
                int num = Integer.parseInt(numStr.toString());
                
                String decodedSubstring = sb.toString();
                for (int i = 0; i < num; i++) {
                    for (char ch : decodedSubstring.toCharArray()) {
                        stack.push(ch);
                    }
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}
