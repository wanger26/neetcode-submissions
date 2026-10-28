class Solution {
    public long repairCars(int[] ranks, int cars) {

        // Time: O((log(r*c^2)))
        // Space: O(logr)

        Arrays.sort(ranks);        

        long left = 1;
        long right = (long)ranks[0] * (long)cars * (long)cars;

        long result = right;
        while(left <= right) {
            long time = (left + right)/2L;

            long carsPossible = 0;
            for(int rank : ranks) {
                carsPossible += (long)Math.sqrt((double)time/(double)rank);

                if(carsPossible > cars) {
                    break;
                }
            }

            if(carsPossible < cars) {
                left = time + 1;
            } else {
                result = time;
                right = time - 1;
            }
        }

        return result;
    }
}
