class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for(int i = 0; i < n; i++) {

            // Try even
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result++;

                left--;
                right++;
            }

            // Try odd
            left = i-1;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result++;

                left--;
                right++;
            }
        }

        return result;
    }
}
