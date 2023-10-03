class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(char[] ch : board) Arrays.fill(ch, '.');

        List<List<String>> ans = new ArrayList<>();

        backtrack(board, 0, n, ans);

        return ans;
    }

    public void backtrack(char[][] board, int col, int n , List<List<String>> ans) {

        if(col == n) {
            List<String> li = addToList(board, new ArrayList<String>());
            ans.add(new ArrayList<String>(li));
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafe(row, col, board)) {
                board[row][col] = 'Q';
                backtrack(board, col+1, n, ans);
                board[row][col] = '.';
            }
        }
        return;
    }

    public boolean isSafe(int row, int col, char[][] board) {

         // check in row
        int x = row; int y = col;
        while(y >= 0) {
            if(board[x][y] == 'Q') return false;
            y--;
        }

        // check in upper diagonal
        x = row; y = col;
        while(x >= 0 && y >= 0) {
            if(board[x][y] == 'Q') return false;
            x--; y--;
        }

        // check in lower diagonal
        x = row; y = col;
        while(x < board.length && y >= 0) {
            if(board[x][y] == 'Q') return false;
            x++; y--;
        }

        return true;
    }

    public List<String> addToList(char[][] board, List<String> li) {

        for(char[] arr  : board) {
            String s = "";
            for(char c : arr) {
                s += c;
            }
            li.add(s);
        }

        return li;
    }
}
