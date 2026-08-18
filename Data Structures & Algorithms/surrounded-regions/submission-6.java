class Solution {
    public void solve(char[][] board) {
        // Pass 1
        for(int i=0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i , 0);
            }

            if (board[i][board[0].length-1] == 'O') {
                dfs(board, i, board[0].length-1);
            }
        }

        // Pass 2
        for(int j=0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[board.length-1][j] == 'O') {
                dfs(board, board.length-1, j);
            }
        }

        // Clean up
        for(int i=0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // If there is an O left --> we can capture
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    // If T --> flip back to O since we csnnot capture
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {

        // Not valid --> nothing to do
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        } else if (board[i][j] != 'O') {
            // If not O nothing to do
            return;
        }

        board[i][j] = 'T';
        dfs(board, i-1, j); // Left
        dfs(board, i+1, j); // Right
        dfs(board, i, j-1); // Up
        dfs(board, i, j+1); // Down
    }
}
