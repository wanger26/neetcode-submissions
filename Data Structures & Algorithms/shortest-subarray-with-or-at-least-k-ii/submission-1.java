class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {

        // Time: O(n)
        // Space: O(1)
        int[] bits = new int[31];

        int left = 0;
        int currentOr = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {

            // Add nums[right] to the window
            for (int bit = 0; bit < 31; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bits[bit]++;
                    currentOr |= (1 << bit);
                }
            }

            // Shrink window while its OR is >= k
            while (left <= right && currentOr >= k) {
                result = Math.min(result, right - left + 1);
                for (int bit = 0; bit < 31; bit++) {
                    if((nums[left] & (1 << bit)) != 0) {
                        bits[bit]--;
                    }

                    if(bits[bit] == 0) {
                        currentOr &= ~(1 << bit);
                    }
                }
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? - 1 : result;
    }
}
