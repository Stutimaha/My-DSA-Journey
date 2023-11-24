class Solution(object):
    def reverseWords(self, s):
        s = s.lstrip()
        arr = s.split()
        ans = ""
        n = len(arr)
        for i in range(n-1, -1, -1):
            ans += arr[i]
            if i>0:
                ans += " "
        return ans
