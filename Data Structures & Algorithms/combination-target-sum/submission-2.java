class Solution {

    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        // Time: O(2^(t/m)) where t is the given target and is the min value in nums
        // Time: O(t/m)
        this.result = new ArrayList<>();

        if(target == 0) {
            return result;
        }

        backtracking(nums, 0, target, new ArrayList<>());

        return result;
    }

    private void backtracking(int[] nums, int index, int target, List<Integer> currentPath) {
        if(index == nums.length) {
            return;
        } else if (target == 0) {
            this.result.add(new ArrayList<>(currentPath));
            return;
        }

        // Option 1: Do not include current
        backtracking(nums, index+1, target, currentPath);

        // Option 2: Include current
        if (target - nums[index] >= 0) {
            currentPath.add(nums[index]);
            backtracking(nums, index, target - nums[index], currentPath);
            currentPath.removeLast();
        }
    }
}
