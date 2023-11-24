class Solution(object):
    def romanToInt(self, s):
        roman = {'I': 1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        num = 0
        previous = 0
        
        for i in reversed(s):
            value = roman.get(i)
            if value<previous:
                num -= value
            else:
                num += value
            previous = value
        return num
        
        