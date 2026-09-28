class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        // Time: O(k*2^n)
        // Space: O(k*2^n)
        int totalSum = 0;
        int maxNum = 0;

        for(int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }

        int targetSubsetSum = totalSum / k;
        if(totalSum % k != 0 || maxNum >  targetSubsetSum) {
            return false;
        }

        return backtracking(nums, 0, k, new boolean[nums.length], 0, targetSubsetSum);
    }

    private boolean backtracking(int[] nums, int index, int k, boolean[] used, int currentSum, int target) {

        if(k == 0) {
            return true;
        } else if (currentSum == target) {
            return backtracking(nums, 0, k - 1, used, 0, target);
        } else if (currentSum > target || index == nums.length) {
            return false;
        }

        // Option 1: Do not include current element in current sum
        boolean result = backtracking(nums, index + 1, k, used, currentSum, target);
        
        // Option 2: Include current element in current sum if allowed
        if(!result && !used[index]) {
            used[index] = true;
            result = backtracking(nums, index + 1, k, used, currentSum + nums[index], target);
            used[index] = false;
        }

        return result;
    }
}