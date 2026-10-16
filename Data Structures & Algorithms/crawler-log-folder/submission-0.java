class Solution {
    public int minOperations(String[] logs) {
        int result = 0;

        // Time: O(n)
        // Time: O(1)
        for(String log : logs) {
            if(log.equals("../")) {
                result = Math.max(result - 1, 0);
            } else if (log.equals("./")) {
                continue;
            } else {
                result++;
            }
        }

        return result;
    }
}