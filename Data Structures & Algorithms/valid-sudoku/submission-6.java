class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Time: O(n*n)
        // Space: O(n*n)
        int n = board.length;

        Set<Integer>[] rowValues = new Set[n];
        Set<Integer>[] colValues = new Set[n];
        Set<Integer>[][] boxValues = new Set[n/3][n/3];
        for(int i = 0; i < n; i++) {
            rowValues[i] = new HashSet<>();
            colValues[i] = new HashSet<>();
            for(int j = 0; j < n/3 && i < n/3; j++) {
                boxValues[i][j] = new HashSet<>();
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '0';
                if(value < 1 || value > 9 || !rowValues[i].add(value) || !colValues[j].add(value) || !boxValues[i/3][j/3].add(value)) {
                    return false;
                }
            }
        }

        return true;
    }
}
