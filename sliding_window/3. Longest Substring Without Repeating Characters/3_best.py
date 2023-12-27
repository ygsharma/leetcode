class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        start = 0
        ans = 0
        for end in range(len(s)):
            # jump start index to max(index stored in map for s[end], start)
            if s[end] in map:
                start = max(start, map[s[end]])
            ans = max(ans, end-start+1)
            # store next index of end in string because we'll straught jump to this index if we found s[end] in map
            map[s[end]] = end+1
            
        return ans
        
