class Solution {
    // Time: O(n)
    // Space: O(1)
    public boolean checkInclusion(String s1, String s2) {
        int[] s1CharIntCount = new int[26];
        int[] windowCharCount = new int[26];

        for(char character : s1.toCharArray()) { // O(m)
            s1CharIntCount[character - 'a']++;
        }


        int left = 0;
        int right = 0;
        while(right < s2.length()) { // O(n)
            int characterIndex = s2.charAt(right) - 'a';

            // If s1 does not contain character --> character cannot be in solution. Skip ahead
            if(s1CharIntCount[characterIndex] == 0) {
                right++;
                left = right;

                // Clear window
                for(int i = 0; i < windowCharCount.length; i++) {
                    windowCharCount[i] = 0;
                }
                continue;
            }

            windowCharCount[characterIndex]++;

            // If current count is too high, won't work. Remove until you are back
            while(windowCharCount[characterIndex] > s1CharIntCount[characterIndex]) {
                int leftCharacterIndex = s2.charAt(left) - 'a';
                windowCharCount[leftCharacterIndex]--;
                left++;
            }

            int totalCharactersMatched = right - left + 1;

            // If s1 contains everything window has with same count then we have found it!
            if(totalCharactersMatched == s1.length()) {
                return true;
            }
            right++;
        }

        return false;
    }
}
