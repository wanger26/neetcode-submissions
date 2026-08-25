class Solution {

    // Time: O(nlogn)
    // Space: O(nlogn)
    public int carFleet(int target, int[] position, int[] speed) {

        // [0,3,5,8,10]
        // [1,3,1,4,2]
        // 12,3,7,1,1]
        //1, 2,  3

        // At position 0: 10
        // At position 4: 3
        // At position 1: 5
        // At position 7: 3


        // At position 1: 10-1/3 = 3
        // At position 4: 10-4/2 = 4

        TreeMap<Integer, Double> positionToTimeMap = new TreeMap<>((a, b) -> b-a);
        for(int i=0; i < position.length; i++) { // O(nlogn)
            double time = (double)(target - position[i])/(double)speed[i];
            positionToTimeMap.put(position[i], time);
        }

        int fleets = 0;
        double slowestTimeAhead = 0;
        for(double time : positionToTimeMap.values()) { // O(n)
            if(time > slowestTimeAhead) { // Current car is slower than slowest car ahead. Will make its own fleet.
                fleets++;
                slowestTimeAhead = time;
            }
        }

        return fleets;
    }
}
