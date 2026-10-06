class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Sort trips by start location
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        
        // Min-heap tracking active trips, sorted by DROP-OFF location
        PriorityQueue<int[]> dropOffs = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        int currentPassengers = 0;
        
        for (int[] trip : trips) {
            // Drop off anyone whose trip ends before or exactly when this new trip starts
            while (!dropOffs.isEmpty() && dropOffs.peek()[2] <= trip[1]) {
                currentPassengers -= dropOffs.poll()[0];
            }
            
            // Pick up new passengers
            currentPassengers += trip[0];
            if (currentPassengers > capacity) {
                return false;
            }
            
            // Add current trip to active drop-offs
            dropOffs.add(trip);
        }
        
        return true;
    }
}