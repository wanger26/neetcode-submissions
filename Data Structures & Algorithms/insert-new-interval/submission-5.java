class Solution {

    // Time: O(n)
    // Space: O(1)
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int index = 0;
        List<int[]> result = new ArrayList<>();
        for(; index < intervals.length && intervals[index][1] < newInterval[0]; index++) {
            result.add(intervals[index]);
        }

        for(; index < intervals.length && intervals[index][0] <= newInterval[1]; index++) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
        }
        result.add(newInterval);

        for(; index < intervals.length; index++) {
            result.add(intervals[index]);
        }


        int[][] resultArray = new int[result.size()][2];
        for(int i=0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
