class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        left, right = 0, 1
        max_profit = 0
        
        while right<len(prices):
            curr_profit = prices[right]-prices[left]
            if curr_profit < 0:
                left = right
                right = left+1
            else:
                right+=1                
                max_profit = max(curr_profit, max_profit)
                
        return max_profit
        