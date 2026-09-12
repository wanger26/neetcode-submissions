class Solution {

    // Time: O(n^2)
    // Space: O(n^2)
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        boolean[][][] subBoxSeen = new boolean[n/3][n/3][10];
        for(int i=0; i < n; i++) {
            boolean[] seen = new boolean[10];
            for(int j=0; j < n; j++) {
                if(board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    int subBoxCol = i/3;
                    int subBoxRow = j/3;
                    if(seen[number] || subBoxSeen[subBoxCol][subBoxRow][number]) {
                        return false;
                    }
                    seen[number] = true;
                    subBoxSeen[subBoxCol][subBoxRow][number] = true;
                }
            }
        }


        for(int j=0; j < n; j++) {
            boolean[] seen = new boolean[10];
            for(int i=0; i < n; i++) {
                if(board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    if(seen[number]) {
                        return false;
                    }
                    seen[number] = true;
                }
            }
        }




        return true;
    }
}
