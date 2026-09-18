class NumMatrix {

    //  1 2  3  4
    //  5 6  7  8
    //  9 10 11 12

    // row1 = 0, col1 = 0, row2 = 1, col2 = 1. 14

    // row1 = 1, col1 = 1, row2 = 2, col2 = 2. 34


    // Row
    // 1  3 6  10
    // 5 11 18 26
    // 9 19 30  43


    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        // Time: O(m*n)
        // Space: O(m*n)

        int n = matrix.length;
        int m = matrix[0].length;

        this.prefixSum = new int[n][m];
        prefixSum[0][0] = matrix[0][0];

        for(int j=1; j < m; j++) {
            prefixSum[0][j] = prefixSum[0][j-1] + matrix[0][j];
        }


        for(int i=1; i < n; i++) {
            prefixSum[i][0] = prefixSum[i-1][0] + matrix[i][0];
            for(int j=1; j < m; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + matrix[i][j] - prefixSum[i-1][j-1];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Time: O(1)

        int totalArea = prefixSum[row2][col2];
        int areaLeftOfRegion = col1-1 < 0 ? 0 : prefixSum[row2][col1-1];
        int areaAboveOfRegion = row1-1 < 0 ? 0 : prefixSum[row1-1][col2];
        int doubleCountedRegion = row1-1 < 0 || col1-1 < 0 ? 0 : prefixSum[row1-1][col1-1];

        return totalArea - areaLeftOfRegion - areaAboveOfRegion + doubleCountedRegion;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */