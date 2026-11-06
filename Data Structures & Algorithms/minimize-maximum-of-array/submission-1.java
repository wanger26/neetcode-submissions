class Solution {
    public int minimizeArrayValue(int[] nums) {

        // Time: O(n)
        // Space: O(n)

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            int maxValueAfterDistribution = (prefixSum[i] + i)/(i+1);
            result = Math.max(result, maxValueAfterDistribution);
        }

        return result;
    }
}
