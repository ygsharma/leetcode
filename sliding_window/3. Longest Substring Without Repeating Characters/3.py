class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        counter = collections.Counter()
        start = 0
        max_length = 0
        for end in range(len(s)):
            counter[s[end]] += 1
            while counter[s[end]] > 1:
                counter[s[start]] -= 1
                if counter[s[start]] == 0:
                    del counter[s[start]]
                start += 1
            max_length = max(end-start+1, max_length)
        return max_length
        
