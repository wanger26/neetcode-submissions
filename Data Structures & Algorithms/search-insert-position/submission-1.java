class Solution {
    public int searchInsert(int[] nums, int target) {

        // Time: O(logn)
        // Space: O(1)
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int pivot = left + (right - left)/2;
            
            if(target == nums[pivot]) {
                return pivot;
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return left;
    }
}