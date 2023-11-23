class Solution(object):
    def firstMissingPositive(self, nums):
        s = set(nums)
        n = len(nums)

        for i in range(1, n + 2):  
            if i not in s:
                return i
