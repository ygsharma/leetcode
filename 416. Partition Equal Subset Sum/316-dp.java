class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int num: nums) {
            sum += num;
        }

        if(sum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[nums.length+1][(sum/2)+1];
        for(int i = 0; i <= nums.length; i++){
            dp[i][0] = true;
        }
        
        for(int i = nums.length-1; i >= 0; i--) {
            for(int target = 0; target <= sum/2; target++){
                boolean inc = false;
                if(target - nums[i] >= 0)
                    inc = dp[i+1][target-nums[i]];
                boolean exc = dp[i+1][target];

                dp[i][target] = inc || exc;
            }
        }
        return dp[0][sum/2];
    }
}
