class Solution {
    public int findRotateSteps(String ring, String key) {

        // Time: O(m*n*k) where k is the max number of repeated chars in ring
        // Space: O(m*n)

        // abcde

        // a -> 0
        // b -> 1
        // c -> 2
        // d -> 3
        // e -> 4

        // a-> e Min(4,1)
        // b-> e Min(4-1,5-4+1)
        int n = ring.length();
        int m = key.length();

        List<Integer>[] charToIndexs = new List[26];
        for(int i = 0; i < 26; i++) {
            charToIndexs[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            char character = ring.charAt(i);
            charToIndexs[character-'a'].add(i);
        }

        int[][] memo = new int[n][m];
        return dp(charToIndexs, ring, key, 0, 0, memo);
    }

    private int dp(List<Integer>[] charToIndexs, String ring, String key, int ringIndex, int keyIndex, int[][] memo) {
        if(keyIndex == key.length()) {
            return 0;
        } else if (memo[ringIndex][keyIndex] != 0) {
            return memo[ringIndex][keyIndex];
        } 

        char nextChar = key.charAt(keyIndex);

        int result = Integer.MAX_VALUE;
        for(int index : charToIndexs[nextChar-'a']) {
            int direct = Math.abs(ringIndex - index);
            int rotationsNeeded = Math.min(direct, ring.length() - direct);
            result = Math.min(result, 1 + rotationsNeeded + dp(charToIndexs, ring, key, index, keyIndex + 1, memo));
        }

        memo[ringIndex][keyIndex] = result;
        return result;
    }
}
