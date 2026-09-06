class Solution {

    // Time: O(logn)
    // Space: O(1)
    public int findMin(int[] nums) {

        int n = nums.length;
        if(nums.length == 1 || nums[0] < nums[n-1]) {
            return nums[0];
        }

        int left = 0;
        int right = n-1;

        while(left < right) {
            int pivot = left + (right-left)/2;
            if(nums[pivot] < nums[right]) {
                // Break/inflection point is in the left side. Go left.
                right = pivot;
            } else{
                left = pivot + 1;
            }
        }

        return nums[left];

    }
}
