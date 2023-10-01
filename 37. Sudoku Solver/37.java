class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        return;
    }

    public boolean solve(char[][] board, int i, int j) {

        if(i == 9) return true;
        if(j == 9) return solve(board, i+1, 0);

        if(board[i][j] != '.') return solve(board, i, j+1);
        
        for(char num = '1'; num <= '9'; num++) {
            if(isValid(board, i, j, (int)num)) {
                board[i][j] = num;
                if(solve(board, i, j+1)) return true;
                board[i][j] = '.';
            }
        }
        
        return false;
    }

    public boolean isValid(char[][] board, int i, int j, int val) {

        // check repetition in the row, col & submatrix
        for(int c = 0; c < 9; c++) {
            if(board[i][c] == val) return false;
            if(board[c][j] == val) return false;
            if(board[3*(i/3) + c/3][3*(j/3) + c%3] == val) return false;
        }
        
        return true;    
    }
}
