class Solution {
    public int tupleSameProduct(int[] nums) {

        // Time: O(n^2)
        // Space: O(n)
        Map<Integer, Integer> productFrequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productFrequency.put(product, productFrequency.getOrDefault(product, 0) + 1);
            }
        }

        int result = 0;
        for(int value : productFrequency.values()) {
            result += 8 * (value * (value-1) / 2);
        }

        return result;
    }
}
