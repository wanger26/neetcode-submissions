class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Time: O(n^2)
        // Space: O(n^2)

        Arrays.sort(nums);
        int n = nums.length;

        List<Integer>[][] memo = new List[n][n];

        return dfs(nums, 0, -1, memo);
    }

    private List<Integer> dfs(int[] nums, int index, int prevIndex, List<Integer>[][] memo) {
        if(index == nums.length) {
            return new ArrayList<>();
        } else if (memo[index][prevIndex+1] != null) {
            return memo[index][prevIndex+1];
        }

        // Option 1: Skip current num
        List<Integer> result = dfs(nums, index + 1, prevIndex, memo);

        // Option 2: Build of current num if possible
        if(prevIndex == -1 || nums[index] % nums[prevIndex] == 0) {
            List<Integer> resultIncluding = new ArrayList<>();
            resultIncluding.add(nums[index]);
            resultIncluding.addAll(dfs(nums, index + 1, index, memo));

            if(resultIncluding.size() > result.size()) {
                result = resultIncluding;
            }
        }

        memo[index][prevIndex+1] = result;
        return result;
    }
}