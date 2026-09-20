class Solution {
    public int combinationSum4(int[] nums, int target) {

        // Time: O(t*n^2)
        // Space: O(t*n)
        Integer[] memo = new Integer[target+1];
        return combinationSum4(nums, 0, target, memo);
    }

    private int combinationSum4(int[] nums, int currentTotal, int target, Integer[] memo) {
        if(currentTotal > target) {
            return 0;
        } else if (memo[currentTotal] != null) {
            return memo[currentTotal];
        } else if(currentTotal == target) {
            return 1;
        }

        int result = 0;
        for(int i=0; i < nums.length; i++) {
            if(currentTotal + nums[i] > target) {
                continue;
            }
            result += combinationSum4(nums, currentTotal + nums[i], target, memo);
        }

        memo[currentTotal] = result;

        return result;
    }
}