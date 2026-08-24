class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a,b) -> {
            int xA = a[0];
            int yA = a[1];

            int xB = b[0];
            int yB = b[1];

            double distanceA = Math.sqrt(Math.pow(xA, 2) + Math.pow(yA, 2));
            double distanceB = Math.sqrt(Math.pow(xB, 2) + Math.pow(yB, 2));

            return Double.compare(distanceB, distanceA);
        });


        for(int[] point : points) {
            maxQueue.add(point);

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
