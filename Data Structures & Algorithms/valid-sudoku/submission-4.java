class Solution {

    // Time: O(n^2)
    // Space: O(n^2)
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        boolean[][] col = new boolean[n][10];
        boolean[][] row = new boolean[n][10];
        boolean[][][] subBoxSeen = new boolean[n/3][n/3][10];
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    int subBoxCol = i/3;
                    int subBoxRow = j/3;

                    if(col[i][number] || row[j][number] || subBoxSeen[subBoxCol][subBoxRow][number]) {
                        return false;
                    }
                    col[i][number] = true;
                    row[j][number] = true;
                    subBoxSeen[subBoxCol][subBoxRow][number] = true;
                }
            }
        }

        return true;
    }
}
