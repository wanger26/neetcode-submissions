class Solution {
    public int combinationSum4(int[] nums, int target) {

        // Time: O(t*n^2)
        // Space: O(t*n)
        Integer[][] memo = new Integer[nums.length][target+1];
        return combinationSum4(nums, 0, 0, target, memo);
    }

    private int combinationSum4(int[] nums, int index, int currentTotal, int target, Integer[][] memo) {
        if(currentTotal > target) {
            return 0;
        } else if (memo[index][currentTotal] != null) {
            return memo[index][currentTotal];
        } else if(currentTotal == target) {
            return 1;
        }

        int result = 0;
        for(int i=0; i < nums.length; i++) {
            if(currentTotal + nums[i] > target) {
                continue;
            }
            result += combinationSum4(nums, i, currentTotal + nums[i], target, memo);
        }

        memo[index][currentTotal] = result;

        return result;
    }
}