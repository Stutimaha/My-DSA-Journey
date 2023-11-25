class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = ''.join(char.lower() for char in s if char.isalnum())
        new = l[::-1]
        return l==new