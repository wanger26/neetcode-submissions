class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // O(k*p) where k is the number of projects and p is the number of profits
        int totalCapital = w;
        for (int projects = 0; projects < k; projects++) {

            int maxCapital = 0;
            int maxProfitIndex = 0;
            for (int i = 0; i < profits.length; i++) {
                if(capital[i] <= totalCapital && maxCapital < profits[i]) {
                    maxProfitIndex = i;
                    maxCapital = profits[i];
                }
            }
            totalCapital += maxCapital;
            profits[maxProfitIndex] = 0; // Marking as used
        }

        return totalCapital;
    }
}