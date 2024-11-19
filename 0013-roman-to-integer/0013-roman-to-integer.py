class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romans = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}
        res = 0
        
        for i in range(len(s)):
            if i+1 < len(s) and romans[s[i]]<romans[s[i+1]]:
                res -= romans[s[i]]
            else:
                res+= romans[s[i]]
        
        return res
        