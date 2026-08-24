class Solution {

    // Time: O(nlogk)
    // Space: O(k)
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a,b) -> {
            long xA = a[0];
            long yA = a[1];

            long xB = b[0];
            long yB = b[1];

            long distanceA = xA*xA + yA*yA;
            long distanceB = xB*xB + yB*yB;

            return Long.compare(distanceB, distanceA);
        });


        for(int[] point : points) { // O(n)
            maxQueue.add(point); // O(logk)

            if(maxQueue.size() > k) {
                maxQueue.poll();
            }
        }


        int[][] result = new int[k][2];
        for(int i=0; i < k; i++) {
            result[i] = maxQueue.poll();
        }

        return result;
    }
}
