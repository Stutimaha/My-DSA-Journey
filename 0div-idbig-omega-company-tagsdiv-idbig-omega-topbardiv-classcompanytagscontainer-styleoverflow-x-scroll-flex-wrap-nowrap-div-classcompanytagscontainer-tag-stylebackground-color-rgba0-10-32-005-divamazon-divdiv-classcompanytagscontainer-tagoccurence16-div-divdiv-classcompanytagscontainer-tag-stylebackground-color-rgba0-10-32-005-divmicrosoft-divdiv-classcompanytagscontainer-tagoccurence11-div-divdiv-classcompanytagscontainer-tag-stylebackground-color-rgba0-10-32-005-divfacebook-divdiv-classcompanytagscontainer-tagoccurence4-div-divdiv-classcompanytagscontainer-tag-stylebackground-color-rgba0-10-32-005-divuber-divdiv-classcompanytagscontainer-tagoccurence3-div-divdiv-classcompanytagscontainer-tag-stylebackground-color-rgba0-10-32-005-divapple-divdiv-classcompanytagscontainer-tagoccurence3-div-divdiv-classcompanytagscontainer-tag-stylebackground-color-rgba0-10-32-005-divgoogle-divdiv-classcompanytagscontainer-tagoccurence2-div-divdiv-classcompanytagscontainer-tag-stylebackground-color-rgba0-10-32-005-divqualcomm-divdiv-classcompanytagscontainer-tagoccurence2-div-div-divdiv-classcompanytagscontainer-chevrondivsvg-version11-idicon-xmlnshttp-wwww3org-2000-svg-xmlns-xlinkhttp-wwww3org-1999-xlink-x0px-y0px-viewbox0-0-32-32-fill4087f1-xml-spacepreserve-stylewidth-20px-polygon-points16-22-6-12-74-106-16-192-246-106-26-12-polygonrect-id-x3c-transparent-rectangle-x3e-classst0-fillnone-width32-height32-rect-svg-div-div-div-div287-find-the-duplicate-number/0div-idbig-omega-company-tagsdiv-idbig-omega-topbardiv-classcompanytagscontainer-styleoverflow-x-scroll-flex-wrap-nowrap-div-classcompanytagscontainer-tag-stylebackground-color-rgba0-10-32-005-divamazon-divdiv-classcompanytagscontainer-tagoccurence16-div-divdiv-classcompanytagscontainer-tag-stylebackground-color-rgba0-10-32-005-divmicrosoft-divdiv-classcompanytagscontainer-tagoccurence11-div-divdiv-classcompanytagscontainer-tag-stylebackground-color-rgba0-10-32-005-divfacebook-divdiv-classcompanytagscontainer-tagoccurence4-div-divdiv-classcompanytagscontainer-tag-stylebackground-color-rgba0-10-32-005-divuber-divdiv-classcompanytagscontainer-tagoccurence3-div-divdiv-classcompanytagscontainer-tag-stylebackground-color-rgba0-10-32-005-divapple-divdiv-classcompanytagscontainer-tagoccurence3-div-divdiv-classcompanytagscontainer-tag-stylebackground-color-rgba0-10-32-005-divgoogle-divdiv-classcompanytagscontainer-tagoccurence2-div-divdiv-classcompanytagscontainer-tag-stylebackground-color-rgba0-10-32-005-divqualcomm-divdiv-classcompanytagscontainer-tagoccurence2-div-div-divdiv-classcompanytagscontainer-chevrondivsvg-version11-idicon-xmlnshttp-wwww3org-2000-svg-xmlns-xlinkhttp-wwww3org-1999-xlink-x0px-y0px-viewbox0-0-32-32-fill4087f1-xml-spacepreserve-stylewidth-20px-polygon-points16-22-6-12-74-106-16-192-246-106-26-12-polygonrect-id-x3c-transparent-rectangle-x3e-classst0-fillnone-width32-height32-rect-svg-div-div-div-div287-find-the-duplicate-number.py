class Solution(object):
    def findDuplicate(self, nums):
        s = set()
        n = len(nums)

        for i in nums:  
            if i in s:
                return i
            else:
                s.add(i)
        