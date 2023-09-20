class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea  = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    if(maxArea < area) maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;

        grid[row][col] = 0;

        int a = dfs(grid, row-1, col);
        int b = dfs(grid, row, col-1);
        int c = dfs(grid, row+1, col);
        int d = dfs(grid, row, col+1);

        return 1+a+b+c+d;
    }
}
