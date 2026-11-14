class Solution {
    public boolean isPalindrome(String s) {

        // Time: O(n)
        // Space: O(1)

        s = s.toLowerCase();
        int n = s.length();

        int left = 0;
        int right = n-1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {                
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
