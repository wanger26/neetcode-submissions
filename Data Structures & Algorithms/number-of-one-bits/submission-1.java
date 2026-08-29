class Solution {
    // Time: O(1)
    // Space: O(1)
    public int hammingWeight(int n) {
        int result = 0;
        for(int i=0; i < 32; i++) {
            int bit = 1 << i & n;
            if(bit != 0) {
                result++;
            }
        }

        return result;

    }
}
