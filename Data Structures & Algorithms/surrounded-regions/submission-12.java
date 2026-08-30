class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] seen = new boolean[n][m];
        for(int x=0; x < n; x++) {
            if(board[x][0] == 'O') {
                dfs(board, x, 0, seen);
            }

            if(board[x][m-1] == 'O') {
                dfs(board, x, m-1, seen);
            }
        }

        for(int y=0; y < m; y++) {
            if(board[0][y] == 'O') {
                dfs(board, 0, y, seen);
            }

            if(board[n-1][y] == 'O') {
                dfs(board, n-1, y, seen);
            }
        }

        for(int x=0; x < n; x++) {
            for(int y=0; y < m; y++) {
                if(board[x][y] == 'T') {
                    board[x][y] = 'O';
                } else if (board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
            }
        }
    }


    private void dfs(char[][] board, int x, int y, boolean[][] seen) {
        if(x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return;
        } else if (seen[x][y] || board[x][y] == 'X') {
            return;
        }

        seen[x][y] = true;
        board[x][y] = 'T';

        dfs(board, x-1, y, seen);
        dfs(board, x+1, y, seen);
        dfs(board, x, y-1, seen);
        dfs(board, x, y+1, seen);
    }
}
