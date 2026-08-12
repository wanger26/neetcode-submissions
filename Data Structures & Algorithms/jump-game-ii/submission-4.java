class Solution {
    public int jump(int[] nums) {
        return dp(nums, 0, new HashMap<>());
    }


    private int dp(int[] nums, int index, Map<Integer, Integer> memo) {

        if (memo.containsKey(index)) {
            return memo.get(index);
        } else if (index >= nums.length - 1) {
            return 0;
        }

        int min = nums.length;
        for (int i=1; i <= nums[index]; i++) {
            min = Math.min(min, 1 + dp(nums, index + i, memo));
        }

        memo.put(index, min);
        return min;
    }
}
