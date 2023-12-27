class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        if(len(s)<3): 
            return len(s)
        map = defaultdict()
        start = 0
        max_length = 0
        for end in range(len(s)):
            map[s[end]] = end
            if len(map) > 2:
                del_idx = min(map.values())
                del map[s[del_idx]]
                start = del_idx+1
            max_length = max(max_length, end-start+1)
            
        return max_length
