class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        start = 0
        max_length = -inf
        map = collections.Counter()
        for end in range(len(nums)):
            map[nums[end]] += 1
            if end-start+1-map[1] > 1:
                map[nums[start]] -= 1
                start+= 1
            max_length = max(max_length, end-start+1-map[0])
        return max_length-1 if map[0] == 0 else max_length
            
