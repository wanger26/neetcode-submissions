class Solution {
    public void wiggleSort(int[] nums) {
        // Time: O(n)
        // Space: O(1)
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i);
            } else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i);
            }
        }
    }

    private void swap(int[] nums, int i) {
        int temp = nums[i];
        nums[i] = nums[i + 1];
        nums[i + 1] = temp;
    }
}
