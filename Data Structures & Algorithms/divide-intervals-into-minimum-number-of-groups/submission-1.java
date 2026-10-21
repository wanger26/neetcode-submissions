class Solution {
    public int minGroups(int[][] intervals) {

        // Time: O(nlogn)
        // Space: O(n)
        int result = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> currentIntervals = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int[] interval : intervals) {
            while (!currentIntervals.isEmpty() && currentIntervals.peek()[1] < interval[0]) {
                currentIntervals.poll();
            }
            currentIntervals.add(interval);
            result = Math.max(result, currentIntervals.size());
        }

        return result;
    }
}
