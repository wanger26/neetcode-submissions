class Solution {
    public boolean canJump(int[] nums) {

        // Top down

        Boolean[] memo = new Boolean[nums.length];

        return dp(memo, nums, 0);
        
    }


    private boolean dp(Boolean[] memo, int[] nums, int stepIndex) {

        if(stepIndex >= nums.length-1) {
            return true;
        } else if (memo[stepIndex] != null) {
            return memo[stepIndex];
        }

        for(int i=1; i<=nums[stepIndex]; i++){
            int nextStepIndex = stepIndex + i;

            boolean result = dp(memo, nums, nextStepIndex);

            if (result) {
                return result;
            }
            memo[nextStepIndex] = false;
        }
        return false;
    }
}
