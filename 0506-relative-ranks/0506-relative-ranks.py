class Solution(object):
    def findRelativeRanks(self, score):
        """
        :type score: List[int]
        :rtype: List[str]
        """
        res = [''] * len(score)
        
        sorted_scores = sorted(((s,i) for i, s in enumerate(score)), reverse = True)
        
        for rank, (score, idx) in enumerate(sorted_scores, start=1):
            if rank == 1:
                res[idx] = "Gold Medal"
            elif rank == 2:
                res[idx] = "Silver Medal"
            elif rank == 3:
                res[idx] = "Bronze Medal"
            else:
                res[idx] = str(rank)
                
        return res