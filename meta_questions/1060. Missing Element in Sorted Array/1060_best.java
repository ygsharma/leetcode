class Solution {
    public int missingElement(int[] nums, int k) {
        
        int i = 0, j = nums.length-1;

        int missingCount = nums[j] - nums[0] - j; 

        // If kth missing number is beyond the last element of nums
        if (k > missingCount) return nums[j] + k - missingCount;

        while(i < j) {
            int mid = i + (j-i)/2;

            if(k > nums[mid]-nums[0]-mid) i = mid+1;
            else j = mid;
        }

        return nums[0] + i - 1 + k;
    }
}
