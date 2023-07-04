class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        // int[][] memo = new int[text1.length()][text2.length()];
        // for(int i = 0 ; i < text1.length() ; i++)
        //     for(int j = 0 ; j < text2.length() ; j++)
        //         memo[i][j] = -1;

        // return memoization(text1, text2, 0, 0, memo);

        return tabulation(text1, text2);
    }

    // Solution 1
    public int memoization(String s1, String s2, int i1, int i2, int[][] memo) {

        if(i1 >= s1.length() || i2 >= s2.length()) return 0;
        if(memo[i1][i2] != -1) return memo[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)){
            return memo[i1][i2] = 1 + memoization(s1, s2, i1+1, i2+1, memo);
        }
        
        int inc1 = memoization(s1, s2, i1+1, i2, memo);
        int inc2 = memoization(s1, s2, i1, i2+1, memo);

        return memo[i1][i2] = Math.max(inc1, inc2); 
        
    }

    // Solution 2
    public int tabulation(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];
      
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else {
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
