class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }

        int n = words.length;
        int maxScore = 0;

        int[] wordScores = new int[n];
        for (int i = 0; i < n; i++) {
            int wordScore = 0;
            for (char c : words[i].toCharArray()) {
                wordScore += score[c - 'a'];
            }
            wordScores[i] = wordScore;
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int[] tempLetterCount = letterCount.clone();
            int subsetScore = 0;
            boolean validSubset = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetScore += wordScores[i];
                    for (char c : words[i].toCharArray()) {
                        int index = c - 'a';
                        if (tempLetterCount[index] > 0) {
                            tempLetterCount[index]--;
                        } else {
                            validSubset = false;
                            break;
                        }
                    }
                }

                if (!validSubset) {
                    break;
                }
            }

            if (validSubset) {
                maxScore = Math.max(maxScore, subsetScore);
            }
        }

        return maxScore;
    }
}
