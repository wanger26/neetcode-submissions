class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;

        // Let n be the number of words
        // Let m be the longest number characters
        // Time: O(n^2*m)
        // Space: O(1)
        for(int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for(int j = i + 1; j < words.length; j++) {
                String word2 = words[j];

                if(word1.length() > word2.length()) {
                    continue;
                }

                boolean valid = true;
                for(int k = 0; k < word1.length() && valid; k++) {
                    if(word1.charAt(k) != word2.charAt(k) || word1.charAt(word1.length() - 1 - k) != word2.charAt(word2.length() - 1 - k)) {
                        valid = false;
                    }
                }

                if (valid) {
                    result++;
                }
            }
        }

        return result;
    }
}