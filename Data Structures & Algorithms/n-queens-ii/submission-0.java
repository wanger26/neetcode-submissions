class Solution {
    public int totalNQueens(int n) {
        boolean[] topLeftToBottomRight = new boolean[2*n-1];
        boolean[] topRightToBottomLeft = new boolean[2*n-1];
        return totalNQueens(n, 0, new boolean[n], topLeftToBottomRight, topRightToBottomLeft);
    }

    public int totalNQueens(int n, int row, boolean[] colsOccupied, boolean[] topLeftToBottomRight, boolean[] topRightToBottomLeft) {
        if(row == n) {
            return 1;
        }

        int result = 0;
        for(int col = 0; col < n; col++) {
            if(colsOccupied[col]) {
                continue;
            }

            int topLeftToBottomRightIndex = row - col + n - 1;

            // Check right to left diagonal
            int topRightToBottomLeftIndex = row + col;


            if(!topLeftToBottomRight[topLeftToBottomRightIndex] && !topRightToBottomLeft[topRightToBottomLeftIndex]) {
                colsOccupied[col] = true;
                topLeftToBottomRight[topLeftToBottomRightIndex] = true;
                topRightToBottomLeft[topRightToBottomLeftIndex] = true;

                result += totalNQueens(n, row + 1, colsOccupied, topLeftToBottomRight, topRightToBottomLeft);
                
                colsOccupied[col] = false;
                topLeftToBottomRight[topLeftToBottomRightIndex] = false;
                topRightToBottomLeft[topRightToBottomLeftIndex] = false;
            }
        }

        return result;
    }

}