class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        if(len(s)<3): 
            return len(s)
        map = defaultdict()
        start = 0
        max_length = 0
        for end in range(len(s)):
            # store index of each char in map
            map[s[end]] = end
            # if len==3: remove the min index char in map such that we have only 2 chars in map
            # make start pointer to del_idx + 1 coz that is our new start point
            if len(map) > 2:
                del_idx = min(map.values())
                del map[s[del_idx]]
                start = del_idx+1
            max_length = max(max_length, end-start+1)
            
        return max_length
