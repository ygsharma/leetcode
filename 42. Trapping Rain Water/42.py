class Solution:
    def trap(self, height: List[int]) -> int:

        left, right = 0, len(height)-1
        maxL, maxR = height[0], height[-1]
        max_water = 0

        while(left < right):
            bottleneck = min(maxL, maxR)
            if bottleneck == maxL:
                if bottleneck - height[left] > 0:
                    max_water += bottleneck - height[left]
                left += 1
                if maxL < height[left]:
                    maxL = height[left]
                
            else:
                if bottleneck - height[right] > 0:
                    max_water += bottleneck - height[right]
                right -= 1
                if maxR < height[right]:
                    maxR = height[right]
                
            
        return max_water


