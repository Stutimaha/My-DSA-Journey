import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                strStack.push(currentStr);
                count = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decodedStr = strStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedStr.append(currentStr);
                }
                currentStr = decodedStr;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
