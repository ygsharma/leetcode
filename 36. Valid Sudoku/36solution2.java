class Solution {

    public boolean isValidSudoku(char[][] board) {

        Set seen = new HashSet();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] != '.') {
                    if(!seen.add(board[i][j] + "," + i/3 + "," + j/3)) {
                        return false;
                    }
                    if(!seen.add(board[i][j] + "row" + i)) return false;
                    if(!seen.add(board[i][j] + "col" + j)) return false;
                }
                
            }
        }
        return true;    
    }
}
