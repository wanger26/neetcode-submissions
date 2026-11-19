class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Time: O(log(m*n))
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0;
        int bottom = n - 1;

        while(top < bottom) {
            int pivot = (top + bottom + 1) / 2;

            if(target == matrix[pivot][0]) {
                return true;
            } else if (target < matrix[pivot][0]) {
                bottom = pivot - 1;
            } else {
                top = pivot;
            }
        }

        int row = top;
        int left = 0;
        int right = m - 1;

        while(left <= right) {
            int pivot = (left + right)/2;

            if(matrix[row][pivot] == target) {
                return true;
            } else if (target < matrix[row][pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return false;
    }
}
