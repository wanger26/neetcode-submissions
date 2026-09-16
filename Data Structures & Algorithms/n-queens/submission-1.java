class Solution {

    public List<List<String>> solveNQueens(int n) {
        // Time: O(n!)
        // Space: O(n*n)
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        dfs(board, 0, new HashSet<>(), result);

        return result;
    }

    private void dfs(char[][] board, int row, Set<Integer> columnsUsed, List<List<String>> result) {
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
            if(!columnsUsed.contains(j) && diagonalCheckPasses(board, row, j)) {
                columnsUsed.add(j);
                board[row][j] = 'Q';
                dfs(board, row+1, columnsUsed, result);
                columnsUsed.remove(j);
                board[row][j] = '.';
            }
        }
    }


    private boolean diagonalCheckPasses(char[][] board, int row, int col) {
        int n = board.length;

        boolean passesCheck = true;
        for(int offset=1; offset < n && passesCheck; offset++) {
            // Checking from current to top left
            if(row - offset >= 0&& col - offset >= 0 && board[row - offset][col - offset] == 'Q') {
                passesCheck = false;
            }

            // Checking from current to top right
            if(row - offset >= 0 && col + offset < n && board[row - offset][col + offset] == 'Q') {
                passesCheck = false;
            }
        }

        return passesCheck;
    }

    
}
