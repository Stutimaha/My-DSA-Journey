class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
            backtrack(num, target, 0, 0, 0, "", result);
            return result;
        }

    private void backtrack(String num, int target, int index, long currentVal, long prevNum, String currentExpr, List<String> result) {
        if (index == num.length()) {
            if (currentVal == target) {
                result.add(currentExpr);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long currentNum = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                backtrack(num, target, i + 1, currentNum, currentNum, currentExpr + currentNum, result);
            } else {
                backtrack(num, target, i + 1, currentVal + currentNum, currentNum, currentExpr + "+" + currentNum, result);
                backtrack(num, target, i + 1, currentVal - currentNum, -currentNum, currentExpr + "-" + currentNum, result);
                backtrack(num, target, i + 1, currentVal - prevNum + prevNum * currentNum, prevNum * currentNum, currentExpr + "*" + currentNum, result);
            }
        }
    }
}