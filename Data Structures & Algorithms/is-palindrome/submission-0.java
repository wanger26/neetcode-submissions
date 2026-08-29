class Solution {
    public boolean isPalindrome(String s) {
        
        String lowerCaseS = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            char leftChar = lowerCaseS.charAt(left);
            char rightChar = lowerCaseS.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if(leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
