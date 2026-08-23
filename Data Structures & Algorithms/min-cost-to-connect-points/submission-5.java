class Solution {
    // Time: O(n^2)
    // Space: O(n)
    public int minCostConnectPoints(int[][] points) {

        int[] smallestKnowDiff = new int[points.length];
        boolean[] alreadyConnected = new boolean[points.length];

        // Initalize - at the begining we know nothing
        Arrays.fill(smallestKnowDiff, Integer.MAX_VALUE);

        smallestKnowDiff[0] = 0;
        int cost = 0;

        for(int i=0; i < points.length; i++) { // O(n)
            int smallestDiff = Integer.MAX_VALUE;
            int nextPointIndex = -1;

            // 1. Find smallest unconnected point
            for(int j=0; j < points.length; j++) { // O(n)
                if(!alreadyConnected[j] && smallestKnowDiff[j] < smallestDiff) {
                    smallestDiff = smallestKnowDiff[j];
                    nextPointIndex = j;
                }
            }

            // 2. Mark current smallest as connected
            alreadyConnected[nextPointIndex] = true;
            cost += smallestDiff;

            int xi = points[nextPointIndex][0];
            int yi = points[nextPointIndex][1];

            // 3. Calculate the smallest know different from new point
            for(int j=0; j < points.length; j++) { // O(n)

                if(alreadyConnected[j]) {
                    continue;
                }
                
                int xj = points[j][0];
                int yj = points[j][1];

                int distance = Math.abs(xi-xj) + Math.abs(yi - yj);
                if(distance < smallestKnowDiff[j]) {
                    smallestKnowDiff[j] = distance;
                }

            }
        }

        return cost;
        
    }
}
