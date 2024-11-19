class Solution(object):
    def twoEggDrop(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [[0] * 3 for _ in range(n + 1)]

        m = 0
        while dp[m][2] < n:
            m += 1
            # With `m` moves and 1 egg
            dp[m][1] = m
            # With `m` moves and 2 eggs
            dp[m][2] = dp[m - 1][1] + dp[m - 1][2] + 1

        return m
