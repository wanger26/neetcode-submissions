class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target |= num;
        }
        int[][] memo = new int[nums.length][target+1];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(nums, 0, 0, target, memo);
    }

    private int dp(int[] nums, int index, int current, int target, int[][] memo) {
        if (current == target) {
            return (int) Math.pow(2, nums.length - index);
        } else if (nums.length == index) {
            return 0;
        } else if (memo[index][current] != -1) {
            return memo[index][current];
        }

        // Option 1: Include current
        int result = dp(nums, index + 1, current | nums[index], target, memo);

        // Option 2: Skip current
        result += dp(nums, index + 1, current, target, memo);

        memo[index][current] = result;

        return result;
    }
}
