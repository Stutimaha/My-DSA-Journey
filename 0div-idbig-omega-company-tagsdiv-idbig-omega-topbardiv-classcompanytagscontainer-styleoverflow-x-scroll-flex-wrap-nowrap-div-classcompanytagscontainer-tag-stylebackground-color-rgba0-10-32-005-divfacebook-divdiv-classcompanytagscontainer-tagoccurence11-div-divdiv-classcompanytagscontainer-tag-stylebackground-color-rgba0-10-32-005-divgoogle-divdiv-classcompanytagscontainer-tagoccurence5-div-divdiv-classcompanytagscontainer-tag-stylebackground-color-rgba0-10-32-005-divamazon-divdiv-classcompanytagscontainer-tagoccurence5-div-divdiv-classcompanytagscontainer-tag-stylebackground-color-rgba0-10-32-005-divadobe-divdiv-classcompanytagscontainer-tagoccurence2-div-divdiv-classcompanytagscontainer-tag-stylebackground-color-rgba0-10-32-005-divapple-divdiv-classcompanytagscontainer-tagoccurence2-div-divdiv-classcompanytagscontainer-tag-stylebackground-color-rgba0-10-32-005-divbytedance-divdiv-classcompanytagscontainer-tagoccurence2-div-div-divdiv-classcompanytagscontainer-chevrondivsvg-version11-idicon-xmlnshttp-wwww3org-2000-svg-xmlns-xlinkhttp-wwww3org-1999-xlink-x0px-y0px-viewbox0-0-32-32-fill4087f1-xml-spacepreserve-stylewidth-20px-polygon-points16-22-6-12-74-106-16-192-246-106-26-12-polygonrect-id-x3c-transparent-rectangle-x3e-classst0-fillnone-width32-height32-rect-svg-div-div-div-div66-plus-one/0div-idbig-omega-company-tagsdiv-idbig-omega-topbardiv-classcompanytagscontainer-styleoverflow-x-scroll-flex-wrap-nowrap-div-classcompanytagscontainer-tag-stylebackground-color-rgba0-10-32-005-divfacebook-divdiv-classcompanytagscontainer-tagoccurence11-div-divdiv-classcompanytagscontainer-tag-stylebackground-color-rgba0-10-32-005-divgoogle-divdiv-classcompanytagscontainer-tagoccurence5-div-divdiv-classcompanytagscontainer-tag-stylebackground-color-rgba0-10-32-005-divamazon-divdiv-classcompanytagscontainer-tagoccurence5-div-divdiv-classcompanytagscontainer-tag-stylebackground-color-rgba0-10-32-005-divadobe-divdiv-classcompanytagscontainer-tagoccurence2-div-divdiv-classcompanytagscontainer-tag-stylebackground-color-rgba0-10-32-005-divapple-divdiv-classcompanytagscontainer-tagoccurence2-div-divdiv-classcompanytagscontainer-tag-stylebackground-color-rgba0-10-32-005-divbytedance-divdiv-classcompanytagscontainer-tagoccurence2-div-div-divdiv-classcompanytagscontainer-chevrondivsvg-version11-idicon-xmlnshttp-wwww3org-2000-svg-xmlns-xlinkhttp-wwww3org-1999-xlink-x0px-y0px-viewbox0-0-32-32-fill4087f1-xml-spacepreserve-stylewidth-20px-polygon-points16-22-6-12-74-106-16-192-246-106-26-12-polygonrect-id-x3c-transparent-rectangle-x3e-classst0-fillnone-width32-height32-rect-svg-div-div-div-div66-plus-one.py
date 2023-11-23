class Solution(object):
    def plusOne(self, digits):
        n = len(digits)
        carry = 1 

        for i in range(n - 1, -1, -1):
            digits[i] += carry
            carry = digits[i] // 10
            digits[i] %= 10

        if carry:
            digits.insert(0, carry)

        while digits and digits[0] == 0:
            digits.pop(0)

        return digits    
