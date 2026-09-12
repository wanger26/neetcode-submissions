class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        boolean[][][] subBoxSeen = new boolean[3][3][10];
        for(int i=0; i < 9; i++) {
            boolean[] seen = new boolean[10];
            for(int j=0; j < 9; j++) {
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


        for(int j=0; j < 9; j++) {
            boolean[] seen = new boolean[10];
            for(int i=0; i < 9; i++) {
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
