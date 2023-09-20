class Solution {
    public void setZeroes(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                   visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(visited[i][j]) {
                   helper(matrix, i, j);
                }
            }
        }
        
    }

    public void helper(int[][] matrix, int row, int col) {

        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        return;
    }

}
