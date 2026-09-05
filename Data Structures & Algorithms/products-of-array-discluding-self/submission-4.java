class Solution {

    // Time: O(n)
    // Space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int totalSumAllowingOneZero = 1;
        int indexOfZero = -1;

        for(int i=0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                if(indexOfZero == -1) {
                    indexOfZero = i;
                } else {
                    return new int[nums.length];
                }
            } else {
                totalSumAllowingOneZero *= num;
            }
        }

        int[] result = new int[nums.length];
        if(indexOfZero != -1) {
            result[indexOfZero] = totalSumAllowingOneZero;
            return result;
        }

        for(int i=0; i < nums.length; i++) {
            result[i] = totalSumAllowingOneZero/nums[i];
        }

        return result;

    }
}  
