class Solution {
    // Time: O(m*4^w) where m is size of board and w is 
    // Space: O(w)
    public boolean exist(char[][] board, String word) {
        for(int x=0; x < board.length; x++){
            for (int y=0; y < board[0].length; y++) {
                if(board[x][y] == word.charAt(0)) {
                    boolean result = dfs(board, x, y, word, 0, new boolean[board.length][board[0].length]);
                    if (result) {
                        return result;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int index, boolean[][] inPath) {
        if (word.length() == index) {
            return true;
        } else if(x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        } else if(inPath[x][y] || word.charAt(index) != board[x][y]) {
            return false;
        }

        inPath[x][y] = true;
        boolean result =dfs(board, x-1, y, word, index+1, inPath) 
        || dfs(board, x+1, y, word, index+1, inPath)
        || dfs(board, x, y-1, word, index+1, inPath)
        || dfs(board, x, y+1, word, index+1, inPath);

        inPath[x][y] = false;

        return result;
    }
}
