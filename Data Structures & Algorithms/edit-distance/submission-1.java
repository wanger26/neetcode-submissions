class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return minDistance(word1, 0, word2, 0, memo);
    }

    private int minDistance(String word1, int index1, String word2, int index2, Integer[][] memo) {
        if(index1 == word1.length()) {
            // Add remaning chars to word1 to make it word2
            return word2.length() - index2;
        } else if(index2 == word2.length()) {
            // Remove remaning chars from word1 to make it word2
            return word1.length() - index1;
        } else if (memo[index1][index2] != null) {
            return memo[index1][index2];
        }

        if(word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = minDistance(word1, index1+1, word2, index2+1, memo);
            return memo[index1][index2];
        }

        int result;
        // Option 1: Add a character. Advance index 2 since it word1 now "matches" at index2
        result = minDistance(word1, index1, word2, index2 + 1, memo);

        // Option 2: Remove a char. Advance index 1 since we skipped that char
        result = Math.min(result, minDistance(word1, index1 + 1, word2, index2, memo));

        // Option 3: replace a char. Advance index 1 and index 2 since we now match
        result = Math.min(result, minDistance(word1, index1+1, word2, index2+1, memo));

        memo[index1][index2] = result + 1;
        return memo[index1][index2];
    }
}
