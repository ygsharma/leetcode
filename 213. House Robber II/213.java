class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int ans1 = helper(Arrays.copyOfRange(nums,0,n-1));
        int ans2 = helper(Arrays.copyOfRange(nums,1,n));

        return Math.max(ans1, ans2);
    }

    public int helper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];

        dp[0] = 0;   
        dp[1] = nums[0];     
        for(int i = 1; i < n; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        
        return dp[n];
    }
}
