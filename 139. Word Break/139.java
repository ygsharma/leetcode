class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i = n; i >= 0; i--){
            for(String word: wordDict) {
                int l = word.length();
                if(i + l <= n && word.equals(s.substring(i, i+l))) dp[i] = dp[i+l];
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
