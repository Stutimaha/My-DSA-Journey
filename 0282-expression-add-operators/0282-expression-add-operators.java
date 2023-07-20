class Solution {
    List<String> ans = new ArrayList<>();
    String s;
    int target;
    public List<String> addOperators(String s, int target) {
        this.s = s;
        this.target = target;
        backtrack( 0, "", 0, 0);
        return ans;
    }
    void backtrack(int i, String path, long resSoFar, long prevNum) {
        if (i == s.length()) {
            if (resSoFar == target) ans.add(path);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (j > i && s.charAt(i) == '0') break; 
            long num = Long.parseLong(s.substring(i, j + 1));
            if (i == 0) {
                backtrack(j + 1, path + num, num, num); 
            } else {
                backtrack(j + 1, path + "+" + num, resSoFar + num, num);
                backtrack(j + 1, path + "-" + num, resSoFar - num, -num);
                backtrack(j + 1, path + "*" + num, resSoFar - prevNum + prevNum * num, prevNum * num); 
            }
        }
    }
}