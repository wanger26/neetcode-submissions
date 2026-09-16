class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> colWithZero = new HashSet<>();
        Set<Integer> rowsWithZero = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    colWithZero.add(i);
                    rowsWithZero.add(j);
                }
            }
        }

        for (int i : colWithZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : rowsWithZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
