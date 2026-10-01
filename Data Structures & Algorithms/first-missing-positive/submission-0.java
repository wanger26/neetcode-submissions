class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Remove all negatives
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Mark postive numbers by making num-1 index negative
        for(int i = 0; i < n; i++) {
            int number = nums[i];
            int numberIndex = Math.abs(number) - 1;
            if(numberIndex < 0 || numberIndex >= n) {
                continue; // Out of bounds --> cannot be answer
            } else if(nums[numberIndex] > 0) {
                nums[numberIndex] *= -1;
            } else if (nums[numberIndex] == 0) {
                nums[numberIndex] = number * -1;
            }
        }

        int smallestNumber = 1;
        for(; smallestNumber <= n; smallestNumber++) {
            int numberIndex = smallestNumber - 1;
            if(nums[numberIndex] >= 0) {
                return smallestNumber;
            }
        }

        return smallestNumber;

    }
}