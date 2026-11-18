class Solution {
    public int longestSubarray(int[] nums) {

        int left = 0;
        int maxElement = -1;

        int result = 1;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] > maxElement) {
                left = right;
                maxElement = nums[right];
                result = 1;
            } else if (nums[right] == maxElement && nums[right-1] == maxElement) {
                result = Math.max(result, right - left + 1);
            } else {
                left = right;
            }
        }

        return result;
    }
}
