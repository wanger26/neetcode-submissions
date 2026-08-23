class Solution {

    // Time: O(nlong)
    // Space: O(n)
    public int[][] merge(int[][] intervals) {

        // 1  --- 3
        // 1 ----------5
        //                6--7

        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for(int i=1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            int currentIntervalStart = currentInterval[0];
            int currentIntervalEnd = currentInterval[1];

            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            // E.g Current:   |--------| 
            // Next:               |--------|
            // 
            if(nextIntervalStart <= currentIntervalEnd) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                // E.g Current:   |--------| 
                // Next:                     |--------|
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add last interval
        result.add(currentInterval);

        int[][] resultArray = new int[result.size()][2];
        for(int i=0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
