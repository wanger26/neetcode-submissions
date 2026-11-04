class Solution {
    public boolean makeEqual(String[] words) {

        // Time: O(n) where n is total num of chars
        // Space: O(1)
        int n = words.length;
        int[] freq = new int[26];

        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                freq[word.charAt(i)-'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] % n != 0) {
                return false;
            }
        }

        return true;
    }
}