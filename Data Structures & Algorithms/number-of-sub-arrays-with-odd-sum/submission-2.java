class Solution {
    public int numOfSubarrays(int[] arr) {

        // Time: O(n)
        // Space: O(1)

        final int mod = (int)1e9 + 7;

        int currentSum = 0;
        int prevOddSums = 0;
        int preEvenSums = 0;
        int result = 0;
        
        for(int num : arr) {
            currentSum += num;

            if(currentSum % 2 == 1) {
                result = (result + 1 + preEvenSums) % mod;
                prevOddSums++;
            } else {
                result = (result + prevOddSums) % mod;
                preEvenSums++;
            }
        }

        return result;
    }
}