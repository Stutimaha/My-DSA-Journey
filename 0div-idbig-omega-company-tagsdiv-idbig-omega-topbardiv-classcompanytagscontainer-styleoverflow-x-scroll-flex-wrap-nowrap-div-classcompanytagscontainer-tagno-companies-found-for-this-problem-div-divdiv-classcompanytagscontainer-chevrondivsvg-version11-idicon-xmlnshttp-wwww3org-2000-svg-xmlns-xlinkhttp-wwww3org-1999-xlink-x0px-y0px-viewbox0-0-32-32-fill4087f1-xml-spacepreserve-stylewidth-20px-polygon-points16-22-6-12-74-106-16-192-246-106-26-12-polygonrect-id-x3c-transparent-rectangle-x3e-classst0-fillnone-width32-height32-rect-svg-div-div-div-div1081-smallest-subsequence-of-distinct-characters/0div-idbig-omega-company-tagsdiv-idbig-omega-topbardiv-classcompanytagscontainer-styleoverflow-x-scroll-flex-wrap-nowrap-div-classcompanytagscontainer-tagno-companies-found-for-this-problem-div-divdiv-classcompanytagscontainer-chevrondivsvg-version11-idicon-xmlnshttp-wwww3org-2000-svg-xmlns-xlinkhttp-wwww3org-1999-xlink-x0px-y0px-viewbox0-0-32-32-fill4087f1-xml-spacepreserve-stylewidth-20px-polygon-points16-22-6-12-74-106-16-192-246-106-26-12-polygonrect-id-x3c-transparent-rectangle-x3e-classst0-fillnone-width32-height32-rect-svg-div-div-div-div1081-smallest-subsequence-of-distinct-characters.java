class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (used[c - 'a']) {
                continue;
            }

            while (result.length() > 0 && c < result.charAt(result.length() - 1) && count[result.charAt(result.length() - 1) - 'a'] > 0) {
                used[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(c);
            used[c - 'a'] = true;
        }

        return result.toString();
    }
}