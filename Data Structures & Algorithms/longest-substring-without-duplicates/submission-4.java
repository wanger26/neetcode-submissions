class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Time: O(n)
        // Space: O(min(n, unique characters))
        Set<Character> window = new HashSet<>();
        int left = 0;

        int result = 0;
        for(int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            
            while(window.contains(currentCharacter) && s.charAt(left) != currentCharacter) {
                window.remove(s.charAt(left));
                left++;
            }

            if(window.contains(currentCharacter)) {
                // Move past duplicate
                left++;
            }

            window.add(currentCharacter);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
