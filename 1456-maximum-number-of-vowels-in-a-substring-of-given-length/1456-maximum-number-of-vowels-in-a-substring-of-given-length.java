class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        char[] ch = s.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(ch[i])) {
                count++;
            }
        } 
        
        int maxCount = count;
        for (int i = k; i < ch.length; i++) {
            if ((set.contains(ch[i]) && set.contains(ch[i - k])) || (!set.contains(ch[i]) && !set.contains(ch[i - k]))) {
                // count remains the same
            } else {
                if (set.contains(ch[i - k])) {
                    count--;
                }
                if (set.contains(ch[i])) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}
