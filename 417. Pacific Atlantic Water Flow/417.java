class Solution {
    
    private int numRows;
    private int numCols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        numRows = heights.length;
        numCols = heights[0].length;
    
        boolean[][] pacific = new boolean[numRows][numCols];
        boolean[][] atlantic = new boolean[numRows][numCols];
        
        for(int i = 0; i < numRows; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, numCols-1, atlantic, heights[i][numCols-1]);
        }

        for(int i = 0; i < numCols; i++) {
            dfs(heights, 0, i, pacific, heights[0][i]);
            dfs(heights, numRows-1, i, atlantic, heights[numRows-1][i]);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
           
        if(r<0 || c<0 || r>=numRows || c>=numCols || visited[r][c] || heights[r][c]<prevHeight){
            return;
        }
        visited[r][c] = true;

        dfs(heights, r+1, c, visited, heights[r][c]);
        dfs(heights, r-1, c, visited, heights[r][c]);
        dfs(heights, r, c+1, visited, heights[r][c]);
        dfs(heights, r, c-1, visited, heights[r][c]);
    }
}
