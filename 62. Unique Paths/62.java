class Solution {
    public int uniquePaths(int m, int n) {
        
        return memoization(m, n, 0, 0, new int[m][n]);
        // return tabulation(m, n);
    }

    // Solution 1
    public int memoization(int m, int n, int i, int j, int[][] memo) {

        if(i == m-1 || j == n-1) return 1;

        if(memo[i][j] > 0) return memo[i][j];

        int r = memoization(m, n, i+1, j, memo);
        int d = memoization(m, n, i, j+1, memo);

        return memo[i][j] = r + d;
    }

    // Solution 2
    public int tabulation(int m, int n) {
        int [][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) 
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
