class Solution {
    public int splitArray(int[] nums, int k) {
        Integer[][] memo = new Integer[nums.length][k+1];
        return splitArray(nums, k, 0, memo);
    }

    private int splitArray(int[] nums, int k, int index, Integer[][] memo) {
        if(index == nums.length && k == 0) {
            return 0;
        } else if (index == nums.length || k == 0) {
            return Integer.MAX_VALUE;
        } else if (memo[index][k] != null) {
            return memo[index][k];
        }

        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        for(int i = index; i <= nums.length - k; i++) {
            currentSum += nums[i];
            result = Math.min(result, Math.max(currentSum, splitArray(nums, k - 1, i+1, memo)));
        }

        memo[index][k] = result;
        return result;
    }
}