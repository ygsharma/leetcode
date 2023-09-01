class Solution {
    private int count = 0;
    private int tsum = 0;
    public int findTargetSumWays(int[] nums, int target) {
       
        for(int i = 0; i < nums.length; i++) tsum += nums[i];

        int[][] memo = new int[nums.length][2*tsum+1];
        for(int[] arr : memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        
        return memoization(nums, 0, 0, target, memo);
    }

    public int memoization(int[] nums, int i, int sum, int target, int[][] memo) {

        if(i == nums.length) {
            if(sum == target) return 1;
            else return 0;
        }
        else{
            if(memo[i][tsum+sum] != Integer.MIN_VALUE) return memo[i][tsum+sum];

            int add = memoization(nums, i+1, sum+nums[i], target, memo);
            int subtract = memoization(nums, i+1, sum-nums[i], target, memo);
            memo[i][tsum+sum] = add + subtract;
        
            return memo[i][tsum+sum];
        }
    }
}
