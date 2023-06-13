class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertion = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                    if (stack.isEmpty()) {
                        insertion++;
                    } else {
                        stack.pop();
                    }
                    i++;
                } else {
                    if (stack.isEmpty()) {
                        insertion += 2;
                    } else {
                        stack.pop();
                        insertion++;
                    }
                }
            }
        }

        insertion += stack.size() * 2; 

        return insertion;
    }
}
