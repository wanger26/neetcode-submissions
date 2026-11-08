class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> maxValuePerX = new HashMap<>();

        for(int i = 0; i < x.length; i++) {
            maxValuePerX.put(x[i], Math.max(maxValuePerX.getOrDefault(x[i], Integer.MIN_VALUE), y[i]));
        }

        int maxNum1 = Integer.MIN_VALUE;
        int maxNum2 = Integer.MIN_VALUE;
        int maxNum3 = Integer.MIN_VALUE;

        if(maxValuePerX.size() < 3) {
            return -1;
        }

        for(int value : maxValuePerX.values()) {
            if(value > maxNum1) {
                maxNum3 = maxNum2;
                maxNum2 = maxNum1;
                maxNum1 = value;
            } else if (value > maxNum2) {
                maxNum3 = maxNum2;
                maxNum2 = value;
            } else if (value > maxNum3) {
                maxNum3 = value;
            }
        }

        return maxNum1 + maxNum2 + maxNum3;
    }
}