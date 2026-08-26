class Solution {
    // Time: O(n)
    // Space: O(1)
    public int climbStairs(int n) {

        if(n < 2) {
            return 1;
        }

        int num1 = 1;
        int num2 = 2;

        for(int i=3; i <= n; i++) {
            int temp = num2;
            num2 = num1 + temp;
            num1 = temp;
        }

        return num2;
    }
}
