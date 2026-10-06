class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // Time: O(nlogn)
        // Time: O(n)

        // [[4,1,2],[3,2,4]],[1,2,3]],[1,3,4]
        //              |      |
        //           [4,2,3], [3,3,4], [1,3,4]
        //                    [4,3,4],

        // Sort by starting location
        PriorityQueue<int[]> minQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] trip : trips) {
            if (trip[0] > capacity) {
                return false;
            }
            minQueue.add(trip);
        }

        int[] currentInterval = minQueue.poll();
        while (!minQueue.isEmpty()) {
            int[] nextInterval = minQueue.poll();

            int currentIntervalEnd = currentInterval[2];
            int currentIntervalSeatCount = currentInterval[0];

            int nextIntervalStart = nextInterval[1];
            int nextIntervalEnd = nextInterval[2];
            int nextIntervalSeatCount = nextInterval[0];

            // Overlap
            if (nextIntervalStart < currentIntervalEnd) {
                if (currentIntervalSeatCount + nextIntervalSeatCount > capacity) {
                    return false;
                }

                // Merge current and next
                currentInterval[0] = currentIntervalSeatCount + nextIntervalSeatCount;
                currentInterval[1] = nextIntervalStart;
                currentInterval[2] = Math.min(nextIntervalEnd, currentIntervalEnd);

                // Add back new interval after we drop passengers off unless current and next drop all passengers off at the same time
                if(currentIntervalEnd < nextIntervalEnd) {
                    minQueue.add(new int[]{nextIntervalSeatCount, currentIntervalEnd, nextIntervalEnd});
                } else if (nextIntervalEnd < currentIntervalEnd) {
                    minQueue.add(new int[]{currentIntervalSeatCount, nextIntervalEnd, currentIntervalEnd});
                }
            } else {
                currentInterval = nextInterval;
            }
        }

        return true;
    }
}