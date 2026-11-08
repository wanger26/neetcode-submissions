class Solution {
    public int minOperations(String s) {

        // Time: O(n)
        // Space: O(1)
        int startWithZero = 0;
        int startWithOne = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    startWithOne++;
                } else {
                    startWithZero++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    startWithOne++;
                } else {
                    startWithZero++;
                }
            }
        }

        return Math.min(startWithZero, startWithOne);
    }
}