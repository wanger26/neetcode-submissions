class Solution {
    // Time: O(nlogn)
    // Space: O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        int currentEnd = intervals[0][1];

        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (currentEnd <= intervals[i][0]) {
                currentEnd = intervals[i][1];
            } else {
                // Conflict, we add to result and keep current smaller interval
                currentEnd = Math.min(currentEnd, intervals[i][1]);
                result++;
            }
        }

        return result;
    }
}
