class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wordBreakHelper(s, dict, new HashSet<>());
    }

    private boolean wordBreakHelper(String s, Set<String> dict, Set<String> memo) {
        if (s.isEmpty()) {
            return true;
        }

        if (memo.contains(s)) {
            return false; 
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                if (wordBreakHelper(suffix, dict, memo)) {
                    return true;
                }
            }
        }

        memo.add(s); // Memoize the result for this substring.
        return false;
    }
}
