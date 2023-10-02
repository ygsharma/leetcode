class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        char c = word.charAt(0);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == c && backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String s, int idx, int r, int c, boolean[][] visited) {
        
        if(idx == s.length()) return true;

        if(r < 0 ||  c < 0 || r >= board.length || c >= board[0].length) return false;
        if(board[r][c] != s.charAt(idx) || visited[r][c]) return false;

        visited[r][c] = true;

        boolean res = backtrack(board, s, idx+1, r+1, c, visited) 
                        || backtrack(board, s, idx+1, r-1, c, visited)
                        || backtrack(board, s, idx+1, r, c+1, visited)
                        || backtrack(board, s, idx+1, r, c-1, visited);
        
        visited[r][c] = false;
        
        return res;
    }
}
