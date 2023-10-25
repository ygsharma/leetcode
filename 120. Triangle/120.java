class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int j = triangle.get(triangle.size()-1).size();
        int[][] memo = new int[triangle.size()][j];

        for(int[] arr : memo) Arrays.fill(arr, -1);

        return dp(triangle, 0, 0, memo);
    }

    public int dp(List<List<Integer>> triangle, int i, int j, int[][] memo) {

        if(i<0 || i>=triangle.size() || j<0 || j>=triangle.get(i).size()) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        int left = dp(triangle, i+1, j, memo);
        int right = dp(triangle, i+1, j+1, memo);

        return memo[i][j] = triangle.get(i).get(j) + Math.min(left, right);
    }
}
