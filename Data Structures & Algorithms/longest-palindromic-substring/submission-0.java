class Solution {
    public String longestPalindrome(String s) {
        int[] longestPalindromeIndexs = new int[2];
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            // Odd palindrom
            int[] indexs = longestPalindrome(s, i, i);

            if(maxLength < indexs[1] - indexs[0]) {
                longestPalindromeIndexs = indexs;
                maxLength = indexs[1] - indexs[0];
            }

            // Even palindrom
            indexs = longestPalindrome(s, i, i+1);
            if(maxLength < indexs[1] - indexs[0]) {
                longestPalindromeIndexs = indexs;
                maxLength = indexs[1] - indexs[0];
            }
        }

        return s.substring(longestPalindromeIndexs[0], longestPalindromeIndexs[1]+1);
    }

    private int[] longestPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return new int[]{left+1, right-1};

    }
}
