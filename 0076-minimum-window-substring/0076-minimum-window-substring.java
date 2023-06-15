class Solution {
    public String minWindow(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int m = s.length();
        int n = t.length();
        String res = "";

        if (n > m) {
            return res;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t_arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = map.size();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < m) {
            char curr = s_arr[right];
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s_arr[left];
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        if (minLength != Integer.MAX_VALUE) {
            res = s.substring(start, start + minLength);
        }

        return res;
    }
}
