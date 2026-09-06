class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones) {
            maxQueue.add(stone);
        }

        while(maxQueue.size() > 1) {
            int stone1 = maxQueue.poll();
            int stone2 = maxQueue.poll();

            int result = stone1-stone2;
            if(result != 0) {
                maxQueue.add(result);
            }
        }

        return maxQueue.isEmpty() ? 0 : maxQueue.poll();
    }
}
