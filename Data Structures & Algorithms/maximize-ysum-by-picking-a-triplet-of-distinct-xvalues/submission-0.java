class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((a,b) -> y[b] - y[a]);
        for(int i = 0; i < x.length; i++) {
            maxQueue.add(i);
        }

        int used = 0;
        Set<Integer> xValues = new HashSet<>();
        int result = 0;

        while(!maxQueue.isEmpty() && used < 3) {
            int index = maxQueue.poll();
            if(xValues.contains(x[index])) {
                continue;
            }

            used++;
            result += y[index];
            xValues.add(x[index]);
        }

        return used == 3 ? result : -1;
    }
}