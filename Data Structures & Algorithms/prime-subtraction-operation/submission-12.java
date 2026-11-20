class Solution {

    public boolean primeSubOperation(int[] nums) {

        // Time: O(n + m*sqrt(m))
        // Space: O(m)
        int maxNum = 0;
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] prime = new int[maxNum + 1];
        for(int i = 2; i <= maxNum; i++) {
            prime[i] = isPrime(i) ? i : prime[i-1];
        }
    
        int prevNum = 0;
        for(int num : nums) {
            if(num <= prevNum) {
                return false;
            }
            prevNum = num - prime[num-prevNum-1];
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
