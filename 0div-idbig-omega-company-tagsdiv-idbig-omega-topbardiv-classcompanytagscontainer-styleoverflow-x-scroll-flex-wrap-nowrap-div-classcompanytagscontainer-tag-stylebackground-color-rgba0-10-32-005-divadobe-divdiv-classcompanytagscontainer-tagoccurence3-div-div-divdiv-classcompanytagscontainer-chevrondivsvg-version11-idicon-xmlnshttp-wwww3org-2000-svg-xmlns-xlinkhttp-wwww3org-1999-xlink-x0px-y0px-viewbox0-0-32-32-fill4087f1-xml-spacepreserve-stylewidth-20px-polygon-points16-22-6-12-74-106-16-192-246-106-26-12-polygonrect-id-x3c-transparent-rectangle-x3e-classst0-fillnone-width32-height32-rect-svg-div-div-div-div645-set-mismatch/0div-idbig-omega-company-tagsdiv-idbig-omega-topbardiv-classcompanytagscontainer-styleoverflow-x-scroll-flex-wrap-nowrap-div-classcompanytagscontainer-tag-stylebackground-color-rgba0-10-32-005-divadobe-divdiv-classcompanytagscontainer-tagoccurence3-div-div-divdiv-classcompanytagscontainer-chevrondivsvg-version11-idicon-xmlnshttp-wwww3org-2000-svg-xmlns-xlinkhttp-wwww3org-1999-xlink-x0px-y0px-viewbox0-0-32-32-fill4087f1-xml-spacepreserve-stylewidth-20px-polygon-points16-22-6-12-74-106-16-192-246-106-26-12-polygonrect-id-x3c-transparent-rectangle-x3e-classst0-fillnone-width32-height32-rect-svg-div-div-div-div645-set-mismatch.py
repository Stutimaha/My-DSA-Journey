class Solution(object):
    def findErrorNums(self, nums):
        s = set()
        n = len(nums)
        l = []

        repeated = None

        for num in nums:
            if num in s:
                repeated = num
            s.add(num)

        for i in range(1, n + 1):
            if i not in s:
                l.append(i)

        return [repeated, l[0]]
            

        
        