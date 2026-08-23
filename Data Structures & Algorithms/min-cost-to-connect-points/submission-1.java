class Solution {
    public int minCostConnectPoints(int[][] points) {

        // minQueue: (index: 1, cost 4),

        PriorityQueue<PointDistance> minQueue = new PriorityQueue<>((a,b) -> a.distance() - b.distance());
        Set<Integer> visited = new HashSet<>();

        int cost = 0;
        minQueue.add(new PointDistance(0,0));
        while(visited.size() < points.length) {
            PointDistance minPointDistance = minQueue.poll();
            int index = minPointDistance.indexInPoints();

            if(!visited.add(index)) {
                continue;
            }

            cost += minPointDistance.distance();

            int xi = points[index][0];
            int yi = points[index][1];

            for(int j=0; j < points.length; j++) {
                if(index == j || visited.contains(j)) {
                    continue;
                }
                int xj = points[j][0];
                int yj = points[j][1];

                int distance = Math.abs(xi - xj) + Math.abs(yi - yj);
                minQueue.add(new PointDistance(j, distance));
            }
        }

        return cost;
        
    }

    private record PointDistance(int indexInPoints, int distance){}
}
