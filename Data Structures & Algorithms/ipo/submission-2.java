class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // Time: O(nlogn)
        // Space: O(n)
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++) {
            minCapital.add(i);
        }

        int totalCapital = w;
        for (int projects = 0; projects < k; projects++) {
            while(!minCapital.isEmpty() && capital[minCapital.peek()] <= totalCapital) {
                maxProfit.add(minCapital.poll());
            }

            if(maxProfit.isEmpty()) {
                return totalCapital;
            }

            totalCapital += profits[maxProfit.poll()];
        }

        return totalCapital;
    }
}