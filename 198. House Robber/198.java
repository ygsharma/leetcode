class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];


        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        
        
        for(int i = 0; i < n; i++){
            if(i==0) dp[i] = nums[i];
            else if(i == 1) dp[i] = Math.max(nums[0], nums[1]);
            else if(i == 2) dp[i] = dp[i-2] + nums[i];
            else{
                dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            }
            
        }
        for(int i = 0; i < n; i++){
            System.out.println(dp[i]);
        }
        
        return Math.max(dp[n-2], dp[n-1]); 
    }
}
