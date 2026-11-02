class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {

        // Time: O(n^2)
        // Space: O(n)
        int n = scores.length;

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }

        // Sort by age in increasing order and score in increasing order
        Arrays.sort(pairs, (a,b) -> {
            int result = a[1] - b[1];
            if(result == 0) {
                return a[0] - b[0];
            }
            return result;
        });

        return dp(pairs, 0, 0, new HashMap<>());
    }

    private int dp(int[][] pairs, int index, int minRequired, Map<String, Integer> memo) {
        String key = index + "," + minRequired;
        if(pairs.length == index) {
            return 0;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result = 0;
        // Option 1: Choose
        if(pairs[index][0] >= minRequired) {
            result = pairs[index][0] + dp(pairs, index + 1, Math.max(pairs[index][0], minRequired), memo);
        }

        // Option 2: Do not choose
        result = Math.max(result, dp(pairs, index + 1, minRequired, memo));

        memo.put(key, result);

        return result;
    }
}
