class Solution {

    public boolean isValidSudoku(char[][] board) {

        Set seen = new HashSet();

        boolean[][] check = new boolean[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') check[i][j] = true;
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(check[i][j] && !seen.add(board[i][j] + "," + i/3 + "," + j/3)) return false;

                int c = j+1, r = i+1;

                while(r<board.length){
                    if(check[r][j] && board[r][j] == board[i][j]) return false;
                    r++;
                }
                while(c<board[0].length ) {
                    if(check[i][c] && board[i][c] == board[i][j]) return false;
                    c++;
                }
            }
        }
        return true;    
    }
}
