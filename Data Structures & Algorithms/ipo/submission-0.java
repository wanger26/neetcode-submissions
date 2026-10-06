class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

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
            System.out.println("maxCapital: " + maxCapital);
            totalCapital += maxCapital;
            profits[maxProfitIndex] = 0; // Marking as used
        }

        return totalCapital;
    }
}