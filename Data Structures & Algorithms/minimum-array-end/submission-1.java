class Solution {
    public long minEnd(int n, int x) {

        // Time: O(max(n,x))
        // Space: O(1)
        long result = x;
        long value = n - 1;
        long bitPosition = 1;

        while(value > 0) {
            // if the current bit in x is a 0 --> we can modify it
            if((result & bitPosition) == 0) {
                // Take the least significant bit of value here
                result |= (value & 1) * bitPosition;
                // Move to the next bit of v
                value >>= 1;
            }
            // Move to the next bit position to check in result
            bitPosition <<= 1;
        }

        return result;

    }
}