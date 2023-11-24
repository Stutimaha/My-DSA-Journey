class Solution(object):
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
        strs.sort()
        first = strs[0]
        last = strs[-1]
        common = ""
        for i in range(len(first)):
            if i <len(last) and first[i]==last[i]:
                common += first[i]
            else:
                break
        return common
            
        
