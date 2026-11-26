class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int fullMask = (1 << n) - 1;
        int[] palindromeLength = new int[fullMask + 1];

        for(int mask = 1; mask <= fullMask; mask++) {
            if(isPalindrome(s, mask)) {
                palindromeLength[mask] = Integer.bitCount(mask);
            }
        }

        int result = 0;
        for(int first = 1; first <= fullMask; first++) {
            if(palindromeLength[first] == 0) {
                continue;
            }

            int unused = fullMask ^ first;
            for(int second = unused; second != 0; second = (second - 1) & unused) {
                result = Math.max(result, palindromeLength[first] * palindromeLength[second]);
            }
        }

        return result;
    }


    private boolean isPalindrome(String s, int mask) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if((mask & (1 << left)) == 0) {
                left++;
            } else if ((mask & (1 << right)) == 0) {
                right--;
            } else {
                if(s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}
