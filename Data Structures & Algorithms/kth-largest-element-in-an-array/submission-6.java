class Solution {
    // Time: O(n) - Average Case, O(n^2) worst case
    // Space: O(1)
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k;

        while (true) {
            int pivot = left;
            for (int i = left; i < right; i++) {
                if (nums[i] <= nums[right]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    pivot++;
                }
            }

            int temp = nums[pivot];
            nums[pivot] = nums[right];
            nums[right] = temp;

            if (pivot == k) {
                return nums[pivot];
            } else if (k < pivot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
    }

}
