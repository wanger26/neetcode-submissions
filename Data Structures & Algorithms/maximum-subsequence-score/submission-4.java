class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        // Time: O(nlogn)
        // Space: O(n)
        
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a,b) -> b[1] - a[1]);

        long num1Sum = 0;
        long minNum2 = 0;

        long result = 0;
        PriorityQueue<Integer> num1MinHeap = new PriorityQueue<>((a,b) -> a - b);
        for(int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];

            num1MinHeap.add(num1);

            num1Sum += (long) num1;
            minNum2 = (long) num2;

            if(num1MinHeap.size() < k) {
                continue;
            } else if(num1MinHeap.size() > k) {
                num1Sum -= (long) num1MinHeap.poll();
            }

            result = Math.max(result, num1Sum * minNum2);
        }

        return result;
    }
}
