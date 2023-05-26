class Solution:
    def maxArea(self, height: List[int]) -> int:

        left = 0;
        right = len(height)-1;
        t_max = 0

        while(left < right):
            if height[left] < height[right]:
                t_max = max(t_max, height[left]*(right-left))
                left += 1
            else:
                t_max = max(t_max, height[right]*(right-left))
                right -= 1
        
        return t_max
            



