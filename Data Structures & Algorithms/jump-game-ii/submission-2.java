class Solution {
    public int jump(int[] nums) {

        int length = nums.length;
        // Bottom Up 
        int[] dp = new int[length];
        for(int i=length-2; i >= 0; i--) {
            int minSteps = length;
            for(int stepIndex = i+1 ; stepIndex < length && stepIndex - i <= nums[i]; stepIndex++) {
                minSteps = Math.min(minSteps, dp[stepIndex]);
            }
            dp[i] = minSteps + 1;
        }

        return dp[0];

    }
}
