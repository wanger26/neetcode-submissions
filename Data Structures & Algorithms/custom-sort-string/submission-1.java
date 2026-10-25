class Solution {
    public String customSortString(String order, String s) {

        // Time: O(s)
        // Space: O(1)
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder bldr = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char character = order.charAt(i);
            while (freq[character - 'a'] > 0) {
                bldr.append(character);
                freq[character - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                bldr.append((char)('a' + i));
                freq[i]--;
            }
        }

        return bldr.toString();
    }
}