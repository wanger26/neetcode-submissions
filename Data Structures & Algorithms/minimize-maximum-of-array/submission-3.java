class Solution {
    public int minimizeArrayValue(int[] nums) {

        // Time: O(n)
        // Space: O(1)

        int sum = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int maxValueAfterDistribution = (sum + i)/(i+1);
            result = Math.max(result, maxValueAfterDistribution);
        }

        return result;
    }
}
