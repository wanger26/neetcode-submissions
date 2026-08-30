class Solution {
    public double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }

        double result = 1;
        long power = Math.abs((long)n);
        while(power > 0) {

            if(power % 2 != 0) {
                result *= x;
            }
            x *= x;
            power = power/2;
        }

        return n < 0 ? 1 / result : result;
    }
}
