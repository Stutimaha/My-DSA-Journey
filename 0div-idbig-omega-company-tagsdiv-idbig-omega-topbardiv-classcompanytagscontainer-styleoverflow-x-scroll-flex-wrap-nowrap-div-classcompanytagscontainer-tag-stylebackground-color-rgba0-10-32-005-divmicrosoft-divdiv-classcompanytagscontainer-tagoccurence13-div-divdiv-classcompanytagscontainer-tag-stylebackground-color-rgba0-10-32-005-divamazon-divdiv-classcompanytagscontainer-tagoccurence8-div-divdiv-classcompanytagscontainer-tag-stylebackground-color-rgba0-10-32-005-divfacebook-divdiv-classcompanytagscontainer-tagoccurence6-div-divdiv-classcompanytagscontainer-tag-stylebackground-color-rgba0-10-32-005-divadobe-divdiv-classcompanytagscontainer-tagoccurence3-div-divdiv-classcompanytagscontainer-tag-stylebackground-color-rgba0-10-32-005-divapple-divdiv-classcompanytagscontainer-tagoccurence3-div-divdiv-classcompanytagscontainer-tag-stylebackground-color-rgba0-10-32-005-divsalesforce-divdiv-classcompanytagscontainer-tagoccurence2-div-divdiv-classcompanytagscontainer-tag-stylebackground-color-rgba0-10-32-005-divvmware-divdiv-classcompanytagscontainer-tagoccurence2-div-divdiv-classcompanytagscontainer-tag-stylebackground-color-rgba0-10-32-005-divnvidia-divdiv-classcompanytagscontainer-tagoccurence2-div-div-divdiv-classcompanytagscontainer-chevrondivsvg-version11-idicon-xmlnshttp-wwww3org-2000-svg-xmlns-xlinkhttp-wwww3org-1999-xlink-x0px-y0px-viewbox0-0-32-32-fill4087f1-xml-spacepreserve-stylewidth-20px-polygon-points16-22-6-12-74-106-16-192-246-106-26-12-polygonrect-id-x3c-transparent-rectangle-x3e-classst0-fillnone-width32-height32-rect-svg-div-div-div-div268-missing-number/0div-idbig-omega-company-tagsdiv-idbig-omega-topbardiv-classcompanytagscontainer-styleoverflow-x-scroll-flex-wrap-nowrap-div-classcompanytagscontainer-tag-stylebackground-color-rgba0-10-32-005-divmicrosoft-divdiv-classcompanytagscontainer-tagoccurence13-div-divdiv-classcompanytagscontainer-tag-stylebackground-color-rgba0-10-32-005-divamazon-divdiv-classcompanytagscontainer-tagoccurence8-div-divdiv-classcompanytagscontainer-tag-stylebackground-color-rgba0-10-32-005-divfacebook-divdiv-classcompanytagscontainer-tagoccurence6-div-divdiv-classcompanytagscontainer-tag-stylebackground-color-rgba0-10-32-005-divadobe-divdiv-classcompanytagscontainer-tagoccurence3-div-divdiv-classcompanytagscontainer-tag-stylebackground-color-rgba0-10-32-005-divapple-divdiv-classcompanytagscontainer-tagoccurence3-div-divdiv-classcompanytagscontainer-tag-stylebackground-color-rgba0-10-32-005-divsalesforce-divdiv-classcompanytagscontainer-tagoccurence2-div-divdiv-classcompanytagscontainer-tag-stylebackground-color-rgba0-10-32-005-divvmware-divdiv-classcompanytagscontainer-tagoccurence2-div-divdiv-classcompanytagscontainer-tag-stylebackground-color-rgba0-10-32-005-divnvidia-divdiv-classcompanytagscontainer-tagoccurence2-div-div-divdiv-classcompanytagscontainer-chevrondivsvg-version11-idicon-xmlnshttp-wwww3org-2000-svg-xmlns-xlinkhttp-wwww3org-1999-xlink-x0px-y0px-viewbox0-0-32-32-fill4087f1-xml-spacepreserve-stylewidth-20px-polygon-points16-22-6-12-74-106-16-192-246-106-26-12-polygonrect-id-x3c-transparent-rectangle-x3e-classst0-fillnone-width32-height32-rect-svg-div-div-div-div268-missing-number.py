class Solution(object):
    def missingNumber(self, nums):
        s = set(nums)
        n = len(nums)  
        for i in range(n + 1):  
            if i not in s:  
                return i
