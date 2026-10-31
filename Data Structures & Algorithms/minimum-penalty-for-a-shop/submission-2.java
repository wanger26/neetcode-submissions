class Solution {
    public int bestClosingTime(String customers) {

        // Time: O(n)
        // Space: O(1)

        int result = 0;
        int penaltyChange = 0;
        int minPenaltyChange = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penaltyChange--;
            } else {
                penaltyChange++;
            }

            if (penaltyChange < minPenaltyChange) {
                minPenaltyChange = penaltyChange;
                result = i + 1;
            }
        }

        return result;
    }
}