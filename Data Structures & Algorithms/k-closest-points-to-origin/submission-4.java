class Solution {
    // Time: O(nlogk)
    // Space: O(k)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a, b) -> {
            int xA = a[0];
            int yA = a[1];

            int xB = b[0];
            int yB = b[1];

            long distanceA = (long) xA * xA + (long) yA * yA;
            long distanceB = (long) xB * xB + (long) yB * yB;

            return Long.compare(distanceB, distanceA);
        });

        for (int[] point : points) { // O(n)
            maxQueue.add(point); // O(logk)

            if (maxQueue.size() > k) {
                maxQueue.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxQueue.poll();
        }

        return result;
    }
}
