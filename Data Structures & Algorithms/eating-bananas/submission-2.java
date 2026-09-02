class Solution {

    // Time: O(nlogm)
    // Space: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int maxBananas = 0;
        for (int bananas : piles) {
            maxBananas = Math.max(maxBananas, bananas);
        }

        int left = 1;
        int right = maxBananas;

        while (left < right) { // (logm)
            int eatingRate = left + (right - left) / 2;

            int hoursTaken = 0;
            for (int bananas : piles) { // O(n)
                hoursTaken += (bananas / eatingRate) + (bananas % eatingRate != 0 ? 1 : 0);
            }

            if (hoursTaken <= h) {
                // If we hit it right on or have some headroom on time, lets try and eat less
                right = eatingRate; // eatingRate could still be the best if less does not have solution
            } else {
                // If we took too much time, we need to eat faster
                left = eatingRate+1;
            }
        }

        return left;
    }
}
