class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        start = 0
        max_length = -inf
        zero_count = 0
        for end in range(len(nums)):
            zero_count += (nums[end]==0)
            #  Shrink the window until the zero counts come under the limit.
            while zero_count > 1:
                zero_count -= (nums[start]==0)
                start += 1
            max_length = max(max_length, end-start)
        return max_length
            
