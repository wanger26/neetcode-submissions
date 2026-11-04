class Solution {
    public int[][] merge(int[][] intervals) {
        // intervals = [[1,3],[1,5],[6,7]]

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[] currentInterval = intervals[0];

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            if(start <= currentInterval[1]) {
                currentInterval[0] = Math.min(currentInterval[0], start);
                currentInterval[1] = Math.max(currentInterval[1], end);
            } else {
                result.add(currentInterval);
                currentInterval = interval;
            }
        }

        result.add(currentInterval);

        int[][] arrayResult = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }

        return arrayResult;
    }
}
