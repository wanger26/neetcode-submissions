class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Map<Integer, List<Integer>> queryIndexMap = new HashMap<>();
        for(int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (!queryIndexMap.containsKey(query)) {
                queryIndexMap.put(query, new ArrayList<>());
            }
            queryIndexMap.get(query).add(i);
        }
        // Sort queries
        Arrays.sort(queries);

        // Store: [Interval Size, End Interval]
        PriorityQueue<int[]> activeIntervals = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int intervalIndex = 0;
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {

            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= queries[i]) {
                activeIntervals.add(new int[] {intervals[intervalIndex][1] - intervals[intervalIndex][0] + 1, intervals[intervalIndex][1]});
                intervalIndex++;
            }

            while(!activeIntervals.isEmpty() && queries[i] > activeIntervals.peek()[1]) {
                activeIntervals.poll();
            }

            int value = activeIntervals.isEmpty() ? -1 : activeIntervals.peek()[0];
            for (int index : queryIndexMap.get(queries[i])) {
                result[index] = value;
            }
        }


        return result;
        
    }
}
