class Solution {
    public int tribonacci(int n) {

        // Time: O(n)
        // Space: O(1)

        if(n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int dp1 = 0;
        int dp2 = 1;
        int dp3 = 1;

        int result = 0;
        for(int i=3; i <= n; i++) {
            result = dp1 + dp2 + dp3;

            dp1 = dp2;
            dp2 = dp3;
            dp3 = result;
        }

        return result;
    }
}