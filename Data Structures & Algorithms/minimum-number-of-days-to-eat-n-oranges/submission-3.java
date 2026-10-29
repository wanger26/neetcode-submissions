class Solution {
    public int minDays(int n) {
        // Time: O(logn)
        // Space: O(logn)
        Map<Integer, Integer> memo = new HashMap<>();
        return minDays(n, memo);
    }

    private int minDays(int n, Map<Integer, Integer> memo) {
        if(n < 2) {
            return n;
        } else if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = 1 + Math.min(n%2 + minDays(n/2, memo), n%3 + minDays(n/3, memo));
        memo.put(n, result);
        return result;
    }
}
