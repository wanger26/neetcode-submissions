class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        

        // Time: O(n+m)
        // Space: O(n)
        int n = words.length;
        int m = queries.length;
        int[] vowelStringsSum = new int[n];

        int currentSum = 0;
        for(int i = 0; i < n; i++) {
            String word = words[i];
            if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1))) {
                currentSum++;
            }
            vowelStringsSum[i] = currentSum;
        }
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = vowelStringsSum[right] - (left == 0 ? 0 : vowelStringsSum[left-1]);
        }

        return result;
    }

    private boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' ||
        character == 'o' || character == 'u';
    }
}