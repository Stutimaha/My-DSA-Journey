class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        m = 0
        cs = 0
        for i in nums:
            if i == 1:
                cs += 1
                m = max(m , cs)
            else:
                cs = 0
        return m