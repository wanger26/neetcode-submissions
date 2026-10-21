class Solution {
    public double averageWaitingTime(int[][] customers) {
        long nextSlot = 0;
        long totalWaitTime = 0;

        for(int[] customer : customers) {
            long arrivalTime = (long)customer[0];
            long duration = (long) customer[1];
            long waitForSlot = Math.max(0L, nextSlot - arrivalTime);

            nextSlot = Math.max(nextSlot, arrivalTime) + duration;
            totalWaitTime += duration + waitForSlot;
        }

        return (double) totalWaitTime / (double)customers.length;
    }
}