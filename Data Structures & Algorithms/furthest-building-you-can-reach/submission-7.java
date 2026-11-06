class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        for(int i = 1; i < heights.length; i++) {
            int difference = heights[i] - heights[i-1];
            if(difference <= 0) {
                continue;
            }

            maxHeap.add(difference);
            bricks -= difference;

            if(bricks < 0 && ladders == 0) {
                return i - 1;
            } else if (bricks < 0) {
                bricks += maxHeap.poll();
                ladders--;
            }
        }

        return heights.length-1;
    }
}
