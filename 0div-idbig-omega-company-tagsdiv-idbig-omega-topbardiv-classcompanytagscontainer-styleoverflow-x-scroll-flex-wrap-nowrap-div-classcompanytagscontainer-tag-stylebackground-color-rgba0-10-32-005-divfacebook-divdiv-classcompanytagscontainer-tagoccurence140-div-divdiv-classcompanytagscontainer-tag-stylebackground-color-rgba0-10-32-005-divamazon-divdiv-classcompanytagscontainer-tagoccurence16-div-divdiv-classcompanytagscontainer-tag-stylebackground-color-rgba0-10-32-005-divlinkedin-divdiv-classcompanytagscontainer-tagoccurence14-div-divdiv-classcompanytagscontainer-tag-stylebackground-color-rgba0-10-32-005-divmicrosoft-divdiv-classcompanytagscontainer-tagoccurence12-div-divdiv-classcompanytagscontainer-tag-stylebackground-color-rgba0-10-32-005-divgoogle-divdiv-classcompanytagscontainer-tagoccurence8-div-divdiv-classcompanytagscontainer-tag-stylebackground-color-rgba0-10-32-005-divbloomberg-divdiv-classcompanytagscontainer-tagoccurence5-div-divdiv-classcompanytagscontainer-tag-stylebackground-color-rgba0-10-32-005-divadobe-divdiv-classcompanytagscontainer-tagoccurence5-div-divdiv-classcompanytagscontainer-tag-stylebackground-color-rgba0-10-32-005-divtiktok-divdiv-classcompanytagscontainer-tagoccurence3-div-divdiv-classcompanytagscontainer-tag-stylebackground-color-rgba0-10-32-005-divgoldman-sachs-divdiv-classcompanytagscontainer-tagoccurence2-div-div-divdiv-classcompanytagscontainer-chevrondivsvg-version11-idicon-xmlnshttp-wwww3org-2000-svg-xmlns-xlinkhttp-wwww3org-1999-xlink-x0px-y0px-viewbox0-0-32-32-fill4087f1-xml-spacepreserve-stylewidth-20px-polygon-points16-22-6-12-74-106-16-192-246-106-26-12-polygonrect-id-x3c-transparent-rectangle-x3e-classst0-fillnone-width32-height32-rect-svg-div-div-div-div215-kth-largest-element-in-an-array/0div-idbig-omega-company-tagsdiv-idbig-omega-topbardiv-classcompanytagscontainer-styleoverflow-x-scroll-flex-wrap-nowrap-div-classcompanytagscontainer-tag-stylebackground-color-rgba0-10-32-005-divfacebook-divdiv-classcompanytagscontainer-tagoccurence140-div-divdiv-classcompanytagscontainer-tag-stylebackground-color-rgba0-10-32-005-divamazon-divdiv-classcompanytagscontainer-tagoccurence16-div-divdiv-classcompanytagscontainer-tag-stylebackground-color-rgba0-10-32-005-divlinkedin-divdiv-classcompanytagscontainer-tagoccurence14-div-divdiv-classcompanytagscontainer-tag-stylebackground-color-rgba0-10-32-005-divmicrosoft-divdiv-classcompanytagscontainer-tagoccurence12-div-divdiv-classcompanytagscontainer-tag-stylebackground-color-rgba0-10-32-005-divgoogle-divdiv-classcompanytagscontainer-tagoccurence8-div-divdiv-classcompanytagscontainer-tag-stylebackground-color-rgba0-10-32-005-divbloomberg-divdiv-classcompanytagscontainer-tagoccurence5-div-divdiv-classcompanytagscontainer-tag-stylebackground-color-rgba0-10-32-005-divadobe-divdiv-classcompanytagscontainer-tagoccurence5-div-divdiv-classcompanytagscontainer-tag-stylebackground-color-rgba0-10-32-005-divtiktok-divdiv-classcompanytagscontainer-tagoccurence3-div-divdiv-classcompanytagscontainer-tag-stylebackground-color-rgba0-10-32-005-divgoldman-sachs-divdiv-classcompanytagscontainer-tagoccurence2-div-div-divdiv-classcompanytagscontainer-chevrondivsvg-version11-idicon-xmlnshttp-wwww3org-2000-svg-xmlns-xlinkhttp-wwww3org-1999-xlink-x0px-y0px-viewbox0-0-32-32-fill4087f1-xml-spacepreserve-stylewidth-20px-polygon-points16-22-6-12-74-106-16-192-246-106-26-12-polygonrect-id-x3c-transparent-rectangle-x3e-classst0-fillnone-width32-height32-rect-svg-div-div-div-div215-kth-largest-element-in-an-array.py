class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        ans = nums[n-k]
        return ans
        