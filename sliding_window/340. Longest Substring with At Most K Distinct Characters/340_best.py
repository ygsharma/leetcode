class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        counter = collections.Counter()
        max_length = 0
        for end in range(len(s)):
            counter[s[end]] += 1
            
            if len(counter) <= k:
                max_length += 1
            else:
                counter[s[end-max_length]] -= 1
                if(counter[s[end-max_length]] == 0):
                    del counter[s[end-max_length]]
        return max_length

        
