class Solution:
    def frequencySort(self, s: str) -> str:
        freq = {}

        for char in s:
            freq[char] = freq.get(char, 0) + 1

        sorted_chars = sorted(freq.items(), key=itemgetter(1), reverse=True)

        result = ""
        for char, count in sorted_chars:
            result += char * count

        return result
