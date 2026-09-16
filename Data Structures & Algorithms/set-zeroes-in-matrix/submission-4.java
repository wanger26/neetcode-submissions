class Solution {
    public void setZeroes(int[][] matrix) {
        // Time: O(m*n)
        // Time: O(1)

        boolean firstRowMustBeZeroed = false;
        boolean firstColMustBeZeroed = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                    if(i == 0) {
                        firstRowMustBeZeroed = true;
                    }

                    if(j == 0) {
                        firstColMustBeZeroed = true;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowMustBeZeroed) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if(firstColMustBeZeroed) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
