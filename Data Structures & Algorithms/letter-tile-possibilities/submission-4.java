class Solution {
    public int numTilePossibilities(String tiles) {

        // Time: O(n!)
        // Space: O(n)
        int[] freq = new int[26];

        for(char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }

        return backtracking(freq);
    }

    private int backtracking(int[] freq) {
        int result = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) {
                continue;
            }

            freq[i]--;
            result += 1 + backtracking(freq);
            freq[i]++;
        }

        return result;
    }
}