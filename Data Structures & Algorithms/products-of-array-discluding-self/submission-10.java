class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,4,6]
        // [1, 2, 8, 48]
        // [48,48,24,6]

        // Time: O(n)
        // Time: O(1)

        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];

        prefixProduct[0] = nums[0];
        postfixProduct[n-1] = nums[n-1]; 
        for(int i = 1; i < n; i++) {
            prefixProduct[i] = nums[i] * prefixProduct[i-1];
            postfixProduct[n-i-1] = nums[n-i-1] * postfixProduct[n-i];
        }

        int[] result = new int[n];
        for(int i = 1; i < n-1; i++) {
            result[i] = prefixProduct[i-1] * postfixProduct[i+1];
        }
        result[0] = postfixProduct[1];
        result[n-1] = prefixProduct[n-2];

        return result;
    }
}  
