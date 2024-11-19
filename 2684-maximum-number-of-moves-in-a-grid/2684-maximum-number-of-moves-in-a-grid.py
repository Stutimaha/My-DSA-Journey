class Solution(object):
    def maxMoves(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        R, C = len(grid), len(grid[0])
        directions = [[0, 1], [1, 1], [-1, 1]]
        
        memo = {}
        
        def dp(r, c):
            if (r, c) in memo:
                return memo[(r, c)]
            
            res = 0  
            for x, y in directions:
                new_r, new_c = r + x, c + y
                if 0 <= new_r < R and 0 <= new_c < C and grid[r][c] < grid[new_r][new_c]:
                    res = max(res, 1 + dp(new_r, new_c))
            
            memo[(r, c)] = res
            return res
        
        return max(dp(r, 0) for r in range(R))
