class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (sToT.containsKey(cs)) {
                if (!sToT.get(cs).equals(ct)) {
                    return false;  
                }
            } else {
                sToT.put(cs, ct);
            }

            if (tToS.containsKey(ct)) {
                if (tToS.get(ct) != cs) {
                    return false;  
                }
            } else {
                tToS.put(ct, cs);
            }
        }

        return true;
    }
}