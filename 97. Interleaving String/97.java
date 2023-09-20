class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int[] arr : memo) Arrays.fill(arr, -1);

        return memoization(s1, s2, s3, 0, 0, memo); 
    }

    public boolean memoization(String s1, String s2, String s3, int i, int j, int[][] memo) {

        if(i+j == s3.length()) return true;
        if(memo[i][j] != -1) return memo[i][j] == 1;

        boolean ans = false;
        if(i < s1.length() && s3.charAt(i+j) == s1.charAt(i)) {
            ans = memoization(s1, s2, s3, i+1, j, memo);
            if(ans) return true;
        }

        if(j < s2.length() && s3.charAt(i+j) == s2.charAt(j)) {
            ans = memoization(s1, s2, s3, i, j+1, memo);
            if(ans) return true;
        }

        memo[i][j] = ans ? 1 : 0;

        return ans;
    }
}
