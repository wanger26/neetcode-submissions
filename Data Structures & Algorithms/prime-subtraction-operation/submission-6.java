class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] composite = new boolean[max + 1];
        for (int p = 2; p <= max / p; p++) {
            if (!composite[p]) {
                for (int multiple = p * p; multiple <= max; multiple += p) {
                    composite[multiple] = true;
                }
            }
        }

        int[] largestPrimeAtMost = new int[max + 1];
        for (int value = 2; value <= max; value++) {
            largestPrimeAtMost[value] = composite[value]
                    ? largestPrimeAtMost[value - 1]
                    : value;
        }

        int prevNum = 0;
        for (int num : nums) {
            if (num <= prevNum) {
                return false;
            }

            int upperBound = num - prevNum - 1;
            prevNum = num - largestPrimeAtMost[upperBound];
        }

        return true;
    }
}