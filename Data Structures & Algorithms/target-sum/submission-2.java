class Solution {

    // Time: O(nm)
    // Space: O(nm)

    public int findTargetSumWays(int[] nums, int target) {
        Map<Tuple, Integer> memo = new HashMap<>();
        return dp(nums, 0, target, memo);
    }

    private int dp(int[] nums, int index, int target, Map<Tuple, Integer> memo) {
        Tuple key = new Tuple(index, target);

        if (memo.containsKey(key)) {
            return memo.get(key);
        } else if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        int result = 0;
        // Option 1: Add
        result += dp(nums, index+1, target+nums[index], memo);

        // Option 2: Subtract
        result += dp(nums, index+1, target - nums[index], memo);

        memo.put(key, result);
        return result;
    }


    private record Tuple(int index, int target){}
}
