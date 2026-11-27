class Solution {

    // Time: O(logn)
    // Space: O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int pivot = left + (right-left)/2;

            if(target == nums[pivot]) {
                return pivot;
            }

            if(nums[left] <= nums[pivot]) {
                if(target > nums[pivot] || target < nums[left]) {
                    // Go right
                    left = pivot + 1;
                } else {
                    // Go left
                    right = pivot - 1;
                }
            } else {
                if(target < nums[pivot] || target > nums[right]) {
                    // Go left
                    right = pivot - 1;
                } else {
                    // Go right
                    left = pivot + 1;
                }
            }
        }

        return -1;

    }
}
