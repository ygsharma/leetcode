class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        triplets = set()
        for i in range(0, len(nums)-2):

            j = i+1
            k = len(nums)-1

            while(j < k):
                
                sum = nums[i] + nums[j] + nums[k]
                if(sum == 0):
                    triplets.add((nums[i], nums[j], nums[k]))
                    j += 1
                    k -= 1
                elif(sum > 0):
                    k -= 1
                else:
                    j += 1

        return triplets

