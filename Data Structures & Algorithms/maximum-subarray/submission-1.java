class Solution {
    public int maxSubArray(int[] nums) {
        // 2,-3,4,-2,2,1,-1,4
        //      |           |

        // if total -1
        //

        int left = 0;
        int right = 0;

        int max = nums[left];
        int currentSum = 0;
        while (right != nums.length) {
            currentSum += nums[right];
            max = Math.max(max, currentSum);
            right++;

            // Current Sum is less than or equal to 0. We can discard
            if(currentSum <= 0) {
                currentSum = 0;
                left = right;
            }
        }

        return max;
    }
}
