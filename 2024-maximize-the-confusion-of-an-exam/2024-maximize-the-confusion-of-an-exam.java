class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxCount = 0; 
        int maxFrequency = 0; 
        int start = 0; 
        int[] count = new int[26]; 

        for (int end = 0; end < answerKey.length(); end++) {
            char ch = answerKey.charAt(end);
            count[ch - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[ch - 'A']);

            if (end - start + 1 - maxFrequency > k) {
                count[answerKey.charAt(start) - 'A']--;
                start++;
            }

            maxCount = Math.max(maxCount, end - start + 1);
        }

        return maxCount;
    }
}
