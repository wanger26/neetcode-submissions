class Solution {

    // Time: O(n)
    // Space: O(1)
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int currentMin = 1;
        int currentMax = 1;

        for(int num : nums) {
            int updatedMax = num * currentMax;
            int updatedMin = num * currentMin;
            currentMax = Math.max(updatedMax, Math.max(updatedMin, num));
            currentMin = Math.min(updatedMax, Math.min(updatedMin, num));

            result = Math.max(result, currentMax);
        }

        return result;
    }
}
