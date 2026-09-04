class Solution {
    // Time: O(logn)
    // Space: O(logn)
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    private int bs(int[] nums, int target, int left, int right) {
        if (right < left) {
            return -1;
        }

        int pivot = left + (right - left) / 2;

        if (nums[pivot] == target) {
            return pivot;
        } else if (target < nums[pivot]) {
            right = pivot - 1;
        } else {
            left = pivot + 1;
        }

        return bs(nums, target, left, right);
    }
}
