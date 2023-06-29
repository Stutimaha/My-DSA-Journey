class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        char[] ch = s.toCharArray();
        String res = "";
        int increment = (numRows - 1) * 2;
        
        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < ch.length; i += increment) {
                res += ch[i];
                
                if (r > 0 && r < numRows - 1) {
                    int j = i + increment - 2 * r;
                    if (j < ch.length) {
                        res += ch[j];
                    }
                }
            }
        }
        
        return res;
    }
}
