class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        
        res = [[1]]

        if numRows > 1:
            for i in range(1, numRows):
                prev = [0] + res[i-1] + [0]
                row = [prev[j] + prev[j+1] for j in range(len(prev) - 1)]
                res.append(row)

        return res

        