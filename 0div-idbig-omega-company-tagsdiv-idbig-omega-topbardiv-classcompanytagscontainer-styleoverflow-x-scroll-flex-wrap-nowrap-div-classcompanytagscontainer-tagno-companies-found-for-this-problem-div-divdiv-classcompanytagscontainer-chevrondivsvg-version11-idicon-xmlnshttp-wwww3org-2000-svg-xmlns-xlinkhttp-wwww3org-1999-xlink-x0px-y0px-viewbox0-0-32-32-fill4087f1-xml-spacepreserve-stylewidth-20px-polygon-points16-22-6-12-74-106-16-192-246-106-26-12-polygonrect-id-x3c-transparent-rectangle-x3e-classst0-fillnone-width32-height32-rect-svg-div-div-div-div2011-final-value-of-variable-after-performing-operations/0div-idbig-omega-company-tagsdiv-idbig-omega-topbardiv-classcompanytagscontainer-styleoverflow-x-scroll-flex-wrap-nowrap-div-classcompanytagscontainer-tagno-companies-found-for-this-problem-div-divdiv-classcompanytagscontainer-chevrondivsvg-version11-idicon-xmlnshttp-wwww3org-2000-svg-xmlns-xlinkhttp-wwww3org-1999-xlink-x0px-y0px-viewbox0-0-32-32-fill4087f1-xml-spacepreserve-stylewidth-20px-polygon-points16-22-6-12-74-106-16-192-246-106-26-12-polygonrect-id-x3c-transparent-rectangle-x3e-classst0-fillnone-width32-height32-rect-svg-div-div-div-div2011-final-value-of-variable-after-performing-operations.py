class Solution(object):
    def finalValueAfterOperations(self, op):
        x = 0
        for i in op:
            if i=='++X' or i=='X++':
                x+=1
            else:
                x-=1
        return x
        