class Solution {
    public int firstMissingPositive(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        int n = nums.length;
        boolean[] seen = new boolean[n];

        // Mark postive numbers by making num-1 index negative
        for(int i = 0; i < n; i++) {
            int number = nums[i];
            int numberIndex = number - 1;
            if(numberIndex < 0 || numberIndex >= n) {
                continue; // Out of bounds --> cannot be answer
            } else {
                seen[numberIndex] = true;
            }
        }

        int smallestNumber = 1;
        for(int i = 0; i < n; i++) {
            if(!seen[i]) {
                return i + 1;
            }
        }

        return n + 1;
    }
}