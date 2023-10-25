class Solution {
    public boolean validPartition(int[] nums) {
        
        int[] dp = new int[nums.length+1];

        if(nums[0] == nums[1]) dp[1] = 1;
        if(nums.length > 2 && nums[0] == nums[1] && nums[1]==nums[2]) dp[2] = 1;
        if(nums.length > 2 && nums[1] == nums[0]+1 && nums[2]==nums[1]+1) dp[2] = 1;

        for(int i = 3; i < nums.length; i++) {
            if(dp[i-2] == 1 && nums[i] == nums[i-1]) dp[i] = 1;
            if(dp[i-3] == 1 && nums[i] == nums[i-1] && nums[i] == nums[i-2]) dp[i] = 1;
            if(dp[i-3] == 1 && nums[i] == nums[i-1]+1 && nums[i] == nums[i-2]+2) dp[i] = 1;
        }
        return dp[nums.length-1] == 1;
    }
    
}
