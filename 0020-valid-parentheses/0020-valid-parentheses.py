class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        mapping = {')': '(', '}': '{', ']': '['}
        stack = []
        
        for char in s:
            if stack and char in mapping:
                top_element = stack.pop()
                if mapping[char] != top_element:
                    return False
            else:
                stack.append(char)
        
        return not stack
