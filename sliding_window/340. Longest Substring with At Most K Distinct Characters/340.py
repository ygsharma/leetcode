class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        dict = {}
        start = 0
        max_length = -inf
        for end in range(len(s)):
            char = s[end]
            if char not in dict:
                dict[char] = 0
            dict[char] += 1
            while len(dict)>k:
                dict[s[start]] -= 1
                if(dict[s[start]] == 0):
                    del dict[s[start]]
                start+=1
            max_length = max(max_length, end-start+1)
        return max_length

        
