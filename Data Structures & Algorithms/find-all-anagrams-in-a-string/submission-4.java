class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // Time: O(n)
        // Space: O(1), excluding the result
        int[] freq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']--;

            // Keep the window size at most p.length().
            if (right - left + 1 > p.length()) {
                freq[s.charAt(left) - 'a']++;
                left++;
            }

            // Check windows of exactly p.length() characters.
            if (right - left + 1 == p.length()) {
                boolean isAnagram = true;

                for (int count : freq) {
                    if (count != 0) {
                        isAnagram = false;
                        break;
                    }
                }

                if (isAnagram) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}