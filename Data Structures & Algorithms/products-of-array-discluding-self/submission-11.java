class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int totalProduct = 1;
        int numOfZeros = 0;
        for(int num : nums) {
            if(num != 0) {
                totalProduct *= num;
            } else {
                numOfZeros++;
            }
        }

        int[] result = new int[nums.length];
        if(numOfZeros > 1) {
            return result;
        }

        for(int i = 0; i < nums.length; i++) {
            if(numOfZeros == 1 && nums[i] != 0) {
                continue;
            } else if (numOfZeros == 1) {
                result[i] = totalProduct;
                return result;
            }
            result[i] = totalProduct / nums[i];
        }

        return result;
    }
}  
