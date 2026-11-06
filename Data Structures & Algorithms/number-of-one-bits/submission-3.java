class Solution {
    public int hammingWeight(int n) {
        // 101
        //  10

        // Time: O(1)
        // Space: O(1)

        int result = 0;
        while(n != 0) {
            int bit = (n & 1);
            if(bit == 1) {
                result++;
            }
            n = n >> 1;
        }

        return result;
    }
}
