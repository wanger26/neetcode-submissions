class Solution {
    public int getSum(int a, int b) {

        // Time: O(1)
        // Space: O(1)
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        return a;
    }
}
