class Solution {
    // Time: O(n)
    // Space: O(m) where m is unique characters
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> windowCharacters = new HashSet<>();
        int max = 0;

        while(right < s.length()) {
            char rightCharacter = s.charAt(right);
            if(!windowCharacters.add(rightCharacter)) {
                max = Math.max(max, right - left);
                while(s.charAt(left) != rightCharacter){
                    windowCharacters.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }
}
