class Solution {
    public String longestPalindrome(String s) {
        // Edge case protection
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if(s.length() - i <= maxLength/2) {
                break;
            }

            int length1 = expandAroundCenter(s, i, i);
            int length2 = expandAroundCenter(s, i, i + 1);

            int length = Math.max(length1, length2);

            if (length > maxLength) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
                maxLength = length;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}