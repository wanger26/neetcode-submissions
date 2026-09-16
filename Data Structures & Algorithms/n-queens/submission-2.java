class Solution {

    private List<List<String>> result;
    private Set<Integer> columnsUsed;
    private Set<Integer> topLeftDiagonalUsed;
    private Set<Integer> topRightDiagonalUsed;

    public List<List<String>> solveNQueens(int n) {
        // Time: O(n!)
        // Space: O(n*n)
        this.result = new ArrayList<>();
        this.columnsUsed = new HashSet<>();
        this.topLeftDiagonalUsed = new HashSet<>();
        this.topRightDiagonalUsed = new HashSet<>();

        char[][] board = new char[n][n];
        dfs(board, 0);

        return result;
    }

    private void dfs(char[][] board, int row) {
        if(row == board.length) {
            List<String> solution = new ArrayList<>();
            for(int i=0; i < board.length; i++) {
                StringBuilder bldr = new StringBuilder();
                for(int j=0; j < board[0].length; j++) {
                    bldr.append(board[i][j] == 'Q' ? 'Q' : '.');
                }
                solution.add(bldr.toString());
            }
            result.add(solution);
            return;
        }

        // Try placing queen in row
        for(int j=0; j < board[0].length; j++) {
            int topLeftDiagonal = row - j;
            int topRightDiagonal = row + j;

            if(!columnsUsed.contains(j) && !topLeftDiagonalUsed.contains(topLeftDiagonal) && !topRightDiagonalUsed.contains(topRightDiagonal)) {
                columnsUsed.add(j);
                topLeftDiagonalUsed.add(topLeftDiagonal);
                topRightDiagonalUsed.add(topRightDiagonal);
                board[row][j] = 'Q';

                dfs(board, row+1);
                
                columnsUsed.remove(j);
                topLeftDiagonalUsed.remove(topLeftDiagonal);
                topRightDiagonalUsed.remove(topRightDiagonal);
                board[row][j] = '.';
            }
        }
    }

    
}
