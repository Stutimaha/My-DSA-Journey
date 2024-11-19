class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        def cal_score(player):
            score = 0 
            for i in range(len(player)):
                if i-1 >= 0 and player[i-1] == 10 or i-2 >= 0 and player[i-2] == 10:
                    score += 2*player[i]
                else:
                    score += player[i]
            return score
        
                    
        score1 = cal_score(player1)
        score2 = cal_score(player2)
        
        if score1>score2:
            return 1
        elif score1<score2:
            return 2
        else:
            return 0
        