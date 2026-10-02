class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Time: O(w*l) == O(c) where w is the length of the words and l is the longest word OR c is the total number of chars in words
        // Space: O(1)
        int[] rank = new int[26];
        for(int i=0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            int index = 0;
            int minSize = Math.min(word1.length(), word2.length());
            while(index < word1.length() && index < word2.length() && rank[word1.charAt(index)-'a'] == rank[word2.charAt(index)-'a']) {
                index++;
            }

            if(index < minSize && rank[word1.charAt(index)-'a'] > rank[word2.charAt(index)-'a']) {
                return false;
            } else if(index == minSize && word2.length() < word1.length()) {
                return false;
            }
        }

        return true;
    }
}