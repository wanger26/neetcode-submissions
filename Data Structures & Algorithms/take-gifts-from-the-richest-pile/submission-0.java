class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> (b-a));
        for(int gift : gifts) {
            maxQueue.add(gift);
        }

        for(int i = 0; i < k; i++) {
            int numOfGifts = maxQueue.poll();
            maxQueue.add((int)Math.sqrt(numOfGifts));
        }

        long result = 0;
        while(!maxQueue.isEmpty()) {
            result += maxQueue.poll();
        }

        return result;
    }
}