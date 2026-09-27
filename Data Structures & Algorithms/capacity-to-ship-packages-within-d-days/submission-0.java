class Solution {
    public int shipWithinDays(int[] weights, int days) {

        // Time: O(nlogn)
        // Space: O(1)

        int totalSum = 0;
        int maxWeight = -1;

        for(int weight : weights) {
            maxWeight = Math.max(weight, maxWeight);
            totalSum += weight;
        }

        int lowerBound = maxWeight;
        int upperBound = totalSum;


        int left = lowerBound;
        int right = upperBound;

        int result = upperBound;
        while(left <= right) {
            int capacity = left + (right-left)/2;

            int capacityUsed = 0;
            int shipsUsed = 1;
            for(int weight : weights) {
                if(capacityUsed + weight > capacity) {
                    capacityUsed = weight;
                    shipsUsed++;
                } else {
                    capacityUsed += weight;
                }
            }

            if(shipsUsed <= days) {
                // Valid Solution
                result = Math.min(result, capacity);

                // Also Try smaller capacity --> go left
                right = capacity - 1;
            } else {
                // Try bigger capacity --> go right
                left = capacity + 1;
            }
        }

        return result;
        
    }
}