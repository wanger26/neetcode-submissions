class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(n == 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        int left = 0;
        int right = n;
        for(int i = 0; i < nums.length; i+=2) {
            result[i] = nums[left++];
            result[i+1] = nums[right++];
        }

        return result;
    }
}
