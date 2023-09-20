class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && ! visited[i][j]) {
                    helper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, boolean[][] visited, int row, int col) {

        if(row<0 || col<0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        
        helper(grid, visited, row-1, col);
        helper(grid, visited, row, col-1);
        helper(grid, visited, row+1, col);
        helper(grid, visited, row, col+1);

        return;
    }
}
