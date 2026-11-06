class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // Time: O(n log(min(n, ladders + 1)))
        // Space: O(min(n, ladders))

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 1; i < heights.length; i++) {
            int difference = heights[i] - heights[i-1];

            if(difference <= 0) {
                continue;
            }

            minHeap.add(difference);

            if(minHeap.size() > ladders) {
                bricks -= minHeap.poll();
            }

            if(bricks < 0) {
                return i - 1;
            }
        }

        return heights.length - 1;
    }
}