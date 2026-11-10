class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int result = 1;

        int increasing = 1;
        int decreasing = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                increasing = 1;
                decreasing++;
            } else if (nums[i-1] < nums[i]) {
                increasing++;
                decreasing = 1;
            } else {
                increasing = 1;
                decreasing = 1;
            }

            result = Math.max(result, Math.max(increasing, decreasing));
        }

        return result;
    }
}