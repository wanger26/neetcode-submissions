class Solution {
    public boolean canJump(int[] nums) {

        Boolean[] dp = new Boolean[nums.length];

        // Buttom up
        for (int i=nums.length-2; i >= 0; i--) {
            for(int stepSize = 1; stepSize <= nums[i]; stepSize++) {
            
            int nextStepIndex = i+stepSize;
            if(nextStepIndex >= nums.length-1 || Boolean.TRUE.equals(dp[nextStepIndex])) {
                    dp[i] = true;
                }
            }

            if(dp[i] == null) {
                dp[i] = false;
            }
        }

        return nums.length == 1 || Boolean.TRUE.equals(dp[0]);
    }
}
