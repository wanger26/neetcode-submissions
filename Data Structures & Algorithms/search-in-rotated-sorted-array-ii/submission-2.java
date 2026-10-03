class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;

            // If left side is sorted
            if (nums[pivot] == target) {
                return true;
            } else if (nums[left] < nums[pivot]) { // If left side is sorted
                if (nums[left] <= target && target < nums[pivot]) {
                    right = pivot - 1; // If number is between left and pivot in sorted section must be here
                } else {
                    left = pivot + 1;
                }
            } else if (nums[left] > nums[pivot]){
                // Right side is sorted and contains target
                if (target <= nums[right] && target > nums[pivot]) {
                    left = pivot
                        + 1; // If number is between left and pivot in sorted section must be here
                } else {
                    right = pivot - 1;
                }
            } else {
                // We cannot determine which side is sorted
                left++;
            }
        }

        return false;
    }
}