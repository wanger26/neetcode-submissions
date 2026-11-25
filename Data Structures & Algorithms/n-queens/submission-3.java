class Solution {
    List<List<String>> result;
    Set<Integer> colUsed;
    Set<Integer> topLeftDigonalUsed;
    Set<Integer> topRightDigonalUsed;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.colUsed = new HashSet<>();
        this.topLeftDigonalUsed = new HashSet<>();
        this.topRightDigonalUsed = new HashSet<>();
        
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueens(board, 0);
        return this.result;
    }

    private void nQueens(char[][] board, int row) {
        if (row == board.length) {
            List<String> boardAsString = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                boardAsString.add(new String(board[i]));
            }
            result.add(boardAsString);

            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (colUsed.contains(j) || topLeftDigonalUsed.contains(row - j) || topRightDigonalUsed.contains(row + j)) {
                continue;
            }

            board[row][j] = 'Q';
            colUsed.add(j);
            topLeftDigonalUsed.add(row - j);
            topRightDigonalUsed.add(row + j);
            nQueens(board, row + 1);
            board[row][j] = '.';
            colUsed.remove(j);
            topLeftDigonalUsed.remove(row - j);
            topRightDigonalUsed.remove(row + j);
        }
    }
}
