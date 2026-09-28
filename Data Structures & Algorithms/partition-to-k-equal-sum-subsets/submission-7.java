class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // Time: O(k*2^n)
        // Space: O(k*n)
        int n = nums.length;
        int totalSum = 0;
        int maxNum = 0;

        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }

        int targetSubsetSum = totalSum / k;
        if (totalSum % k != 0 || maxNum > targetSubsetSum) {
            return false;
        }

        Arrays.sort(nums);

        return backtracking(nums, n - 1, k, new boolean[nums.length], 0, targetSubsetSum);
    }

    private boolean backtracking(
        int[] nums, int index, int k, boolean[] used, int currentSum, int target) {
        if (k == 1) { // If we've successfully built k-1 subsets, the last subset is mathematically guaranteed to perfectly equal the target.
            return true;
        } else if (currentSum == target) {
            return backtracking(nums, nums.length - 1, k - 1, used, 0, target);
        } else if (currentSum > target || index == nums.length) {
            return false;
        }

        boolean result = false;
        for (int i = index; i >= 0 && !result; i--) {

            if(used[i] || currentSum + nums[i] > target) {
                continue;
            }

            used[i] = true;
            result = backtracking(nums, i - 1, k, used, currentSum + nums[i], target);
            used[i] = false;
        }

        return result;
    }
}