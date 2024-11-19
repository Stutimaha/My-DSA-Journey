class Solution(object):
    def partitionString(self, s):
        """
        :type s: str
        :rtype: int
        """
        sub = set()  
        res = 1  
        
        for c in s:
            if c in sub:  
                res += 1  
                sub = set()  
            
            sub.add(c)  
        
        return res 