class Solution(object):
    def findDisappearedNumbers(self, nums):
        s = set(nums)
        n = len(nums)
        l = list()

        for i in range(1, n+1):  
            if i not in s:
                l.append(i)
        return l
            

        