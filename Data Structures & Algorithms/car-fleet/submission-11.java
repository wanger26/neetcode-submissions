class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> maxQueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < position.length; i++) {
            maxQueue.add(new int[]{position[i], speed[i]});
        }

        int result = 0;
        double slowestCar = 0;
        while(!maxQueue.isEmpty()) {
            int[] car = maxQueue.poll();
            int startingPosition = car[0];
            int speedOfCar = car[1];

            double time = (double) (target - startingPosition) / (double) speedOfCar;
            if(time > slowestCar) {
                slowestCar = time;
                result++;
            }
        }

        return result;
    }
}
