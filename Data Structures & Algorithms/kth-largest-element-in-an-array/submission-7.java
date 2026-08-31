class Solution {

    // Time: O(n) - Average Case, O(n^2) worst case
    // Space: O(n) on average, O(n^2) worst case
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k;

        return quickSelect(nums, left, right, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = left;
        for(int i=left; i < right; i++) {
            if(nums[i] <= nums[right]) {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                pivot++;
            }
        }
        
        int temp = nums[pivot];
        nums[pivot] = nums[right];
        nums[right] = temp;

        if(pivot == k) {
            return nums[pivot];
        } else if (k < pivot) {
            return quickSelect(nums, left, pivot-1, k);
        } else {
            return quickSelect(nums, pivot+1, right, k);
        }
    }
}
