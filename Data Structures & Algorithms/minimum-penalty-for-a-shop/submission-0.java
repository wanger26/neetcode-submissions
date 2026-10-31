class Solution {
    public int bestClosingTime(String customers) {

        // Time: O(n)
        // Space: O(n)
        int n = customers.length();
        int[] lostCustomerPenalty = new int[n+1];
        int[] idlePenalty = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            idlePenalty[i] = idlePenalty[i-1];
            if(customers.charAt(i-1) == 'N') {
                idlePenalty[i]++;
            }
        }

        for(int i = n-1; i >=0; i--) {
            lostCustomerPenalty[i] = lostCustomerPenalty[i+1];
            if(customers.charAt(i) == 'Y') {
                lostCustomerPenalty[i]++;
            }
        }

        int result = 0;
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++) {
            if(lostCustomerPenalty[i] + idlePenalty[i] < minCost) {
                minCost = lostCustomerPenalty[i] + idlePenalty[i];
                result = i;
            }
        }

        return result;
    }
}