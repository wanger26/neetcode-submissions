class Solution {
    public int subsetXORSum(int[] nums) {
        // Start at index 0 with an initial XOR total of 0
        return subsetXORSum(nums, 0, 0);
    }

    private int subsetXORSum(int[] nums, int index, int currentXOR) {
        // Base case: we have reached the end of the array
        if (index == nums.length) {
            // Return the XOR total for this specific subset
            return currentXOR;
        }

        // Option 1: Do not include current number in the XOR total
        int excludeSum = subsetXORSum(nums, index + 1, currentXOR);

        // Option 2: Include current number in the XOR total
        int includeSum = subsetXORSum(nums, index + 1, currentXOR ^ nums[index]);

        // Return the sum of all subsets generated from both choices
        return excludeSum + includeSum;
    }
}