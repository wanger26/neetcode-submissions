class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length;

        long pairsSmallerThanUpper = countFairPairs(nums, upper);
        long pairsSmallerThanLower = countFairPairs(nums, lower-1);

        return pairsSmallerThanUpper - pairsSmallerThanLower;
    }

    public long countFairPairs(int[] nums, int upper) {
        int left = 0;
        int right = nums.length-1;

        long answer = 0;
        while(left <= right) {
            int sum = nums[left] + nums[right];
            if(sum <= upper) {
                answer += right - left;
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }
}
