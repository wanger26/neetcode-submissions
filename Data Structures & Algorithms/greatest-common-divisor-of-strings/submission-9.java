class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Time: O(m+n)
        // Space: O(1)

        int m = str1.length();
        int n = str2.length();
        int gcdLen = gcd(m, n);

        // 1. Verify pattern in str1 without allocating new strings
        for (int i = 0; i < m; i++) {
            if (str1.charAt(i) != str1.charAt(i % gcdLen)) {
                return "";
            }
        }

        // 2. Verify str2 matches str1's pattern
        for (int i = 0; i < n; i++) {
            if (str2.charAt(i) != str1.charAt(i % gcdLen)){
                return "";
            }
        }

        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}