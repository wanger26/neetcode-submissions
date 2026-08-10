class Solution {
    public boolean canJump(int[] nums) {

        int maxReachedIndex = 0;

        for(int i=0; i<nums.length && maxReachedIndex < nums.length-1; i++) {
            if (maxReachedIndex < i) {
                // we got stuck
                return false;
            }

            maxReachedIndex = Math.max(maxReachedIndex, i+nums[i]);
        }

        return maxReachedIndex >= nums.length-1;
        
    }
}
