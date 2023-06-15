import java.util.HashMap;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();

        int s1_len = s1.length();
        int s2_len = s2.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1_arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int window = s1_len;
        int right = 0;
        int left = 0;

        while (right < s2_len) {
            char charRight = s2_arr[right];
            if (map.containsKey(charRight)) {
                map.put(charRight, map.get(charRight) - 1);
                if (map.get(charRight) >= 0) {
                    window--;
                }
            }
            right++;

            if (window == 0) {
                return true;
            }

            if (right - left == s1_len) {
                char charLeft = s2_arr[left];
                if (map.containsKey(charLeft)) {
                    map.put(charLeft, map.get(charLeft) + 1);
                    if (map.get(charLeft) > 0) {
                        window++;
                    }
                }
                left++;
            }
        }

        return false;
    }
}
