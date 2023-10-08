class Solution {
    public int minOperations(String s1, String s2, int x) {
        
        List<Integer> diff = new ArrayList<Integer>();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) diff.add(i);
        } 

        // if total mismatch is odd return -1
        // because swap will need 2 or even indexes
        if(diff.size()%2 != 0) return -1;

        int[][] dp = new int[s1.length()][s1.length()];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        return dfs(0, diff.size()-1, x, diff, dp);
    }

    public int dfs(int l, int r, int x, List<Integer> diff, int[][] dp) {

        if(l>=r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        // there are 3 swap options: (l+1,l), (l,r), (r,r-1)
        // l+1,l -> take min((l+1)-l, x) cost
        int ans = Math.min(diff.get(l+1)-diff.get(l), x) + dfs(l+2, r, x, diff, dp);
        // (l,r) we'll have x cost
        ans = Math.min(ans,  x + dfs(l+1, r-1, x, diff, dp));
        // (r,r-1) -> take min(r-(r-1), x) cost
        ans = Math.min(ans, Math.min(diff.get(r)-diff.get(r-1), x) + dfs(l, r-2, x, diff, dp));

        return dp[l][r] = ans;
    }
}
