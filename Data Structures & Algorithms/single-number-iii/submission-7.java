class Solution {
    public int[] singleNumber(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        int xorSum = 0;
        for(int num : nums) {
            xorSum ^= num;
        }

        int[] result = new int[2];

        int locationOf1 = -1;
        for(int i = 0; i < 32 && locationOf1 == -1; i++) {
            if(((xorSum >>> i) & 1) == 1) {
                locationOf1 = i;
            }
        }

        for(int num : nums) {
            if(((num >>> locationOf1) & 1) == 1) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}