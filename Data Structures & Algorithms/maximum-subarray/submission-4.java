class Solution {
    // Time: O(n)
    // Space: O(1)
    public int maxSubArray(int[] nums) {
        // 2,-3,4,-2,2,1,-1,4
        //      |           |

        // if total -1
        //

        int right = 0;

        int max = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Current Sum is less than or equal to 0. We can discard
            if (currentSum <= 0) {
                currentSum = 0;
            }
            currentSum += nums[i];
            max = Math.max(max, currentSum);
        }

        return max;
    }
}
