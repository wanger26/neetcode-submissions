class Solution {

    public boolean primeSubOperation(int[] nums) {
        // Time: O(n*p) where p is largest gap in between a given number and its largest prime value
        // Space: O(1)
        int prevNum = 0;
        for(int i = 0; i < nums.length; i++) {
            int upperBound = nums[i] - prevNum - 1;

            int largestPrime = 0;
            for(int number = upperBound; number >= 2 && largestPrime == 0; number--) {
                if(isPrime(number)) {
                    largestPrime = number;
                }
            }

            int newNum = nums[i] - largestPrime;
            if(newNum <= prevNum) {
                return false;
            }
            prevNum = newNum;
        }

        return true;
    }

    private boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
