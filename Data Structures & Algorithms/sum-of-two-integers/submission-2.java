class Solution {
    // Time: O(1)
    // Space: O(1)
    public int getSum(int a, int b) {
        while(b != 0) { // While we have carry
            int carry = (a & b) << 1; // AND operation and shift since we are doing a carry forward (otherwise we would not move forward)
            a = a ^ b; // XOR operation
            b = carry;
        }

        return a;
    }
}
