class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // Time: O(n)
        // Space: O(n)
        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];

        List<int[]> merged = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length && intervals[i][1] < newIntervalStart; i++) {
            merged.add(intervals[i]);
        }

        for (; i < intervals.length && newIntervalEnd >= intervals[i][0]; i++) {
            newIntervalStart = Math.min(newIntervalStart, intervals[i][0]);
            newIntervalEnd = Math.max(newIntervalEnd, intervals[i][1]);
        }

        merged.add(new int[]{newIntervalStart, newIntervalEnd});

        for (; i < intervals.length; i++) {
            merged.add(intervals[i]);
        }

        int[][] result = new int[merged.size()][2];
        for (int j = 0; j < merged.size(); j++) {
            result[j] = merged.get(j);
        }

        return result;
    }
}
