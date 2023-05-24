class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        dict = {}
        for i in nums:
            dict[i] = 1

        max_len = 0

        for i in nums:
             if i-1 not in dict.keys():
                curr_len = 1
                while i+1 in dict.keys():
                    curr_len += 1
                    i += 1
                max_len = max(max_len, curr_len)

        return max_len
                


 
