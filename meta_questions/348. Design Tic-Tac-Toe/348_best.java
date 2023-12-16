class TicTacToe {
    int[] rows;
    int[] cols;
    int n;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        
        int currentPlayer = player == 1 ? 1 : -1;
        
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        if(row == col) diagonal += currentPlayer;
        if(col == n-row-1) antiDiagonal += currentPlayer;

        if(Math.abs(rows[row]) == n || 
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) return player;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
