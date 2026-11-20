class Solution {

    public boolean primeSubOperation(int[] nums) {

        int maxNum = 0;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        boolean[] prime = new boolean[maxNum + 1];
        prime[1] = true;
        for(int i = 1; i <= maxNum; i++) {
            prime[i] = isPrime(i);
        }
    
        int prevNum = 0;
        for(int i = 0; i < nums.length; i++) {
            int upperBound = nums[i] - prevNum - 1;

            int largestPrime = 0;
            for(int number = upperBound; number >= 2 && largestPrime == 0; number--) {
                if(prime[number]) {
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
