class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = helper(coins, amount, dp);

        return  ans == Integer.MAX_VALUE ? -1: ans; 
    }

    public int helper(int[] coins, int n, int[] dp) {
        if(n == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            if(n-coins[i] >= 0) {
                int subAns = 0;
                if(dp[n-coins[i]] != -1) subAns = dp[n-coins[i]];
                else subAns = helper(coins, n-coins[i], dp);

                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) ans = subAns+1;
            }
            
        }
        return dp[n] = ans;
    }
}
