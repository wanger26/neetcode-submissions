class Solution {
    public int countSubstrings(String s) {

        // Time: O(n^2)
        // Space: O(1)

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            // Odd number palindroms
            result += expandFromMiddle(s, i, i);

            // Even number palindroms
            result += expandFromMiddle(s, i, i+1);
        }

        return result;
    }

    private int expandFromMiddle(String s, int left, int right) {
        int validPalindroms = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            validPalindroms++;
            left--;
            right++;
        }

        return validPalindroms;
    }
}
