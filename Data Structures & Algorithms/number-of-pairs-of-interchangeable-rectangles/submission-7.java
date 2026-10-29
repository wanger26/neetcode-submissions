class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> freqCount = new HashMap<>();

        for(int[] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            int divisor = gcd(width, height);

            String key = (width/divisor) + "," + (height/divisor);
            freqCount.put(key, freqCount.getOrDefault(key, 0L) + 1);
        }

        long result = 0;
        for(long frequency : freqCount.values()) {
            result += frequency * (frequency - 1L) / 2L;
        }

        return result;
    }

    private int gcd(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }

        return gcd(num2, num1 % num2);
    }
}
