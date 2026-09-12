class Solution {

    // Time: O(logm + logn)
    // Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bsUpDown(matrix, target);

        if (row < 0 || row == matrix.length) {
            return false;
        } else if(matrix[row][0] == target) {
            return true;
        }

        System.out.println(row);
        return bs(matrix[row], target);
    }

    private int bsUpDown(int[][] matrix, int target) {

        int up = 0;
        int down = matrix.length - 1;

        while(up <= down) {
            int pivot = up + (down-up)/2;

            if(matrix[pivot][0] == target) {
                return pivot;
            } else if (target < matrix[pivot][0]) {
                // Go up
                down = pivot - 1;
            } else {
                // Go down
                up = pivot + 1;
            }
        }

        return down;
    }

    private boolean bs(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int pivot = left + (right-left)/2;
            if(nums[pivot] == target) {
                return true;
            } else if (target < nums[pivot]) {
                // Go left
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return false;
    }
}
