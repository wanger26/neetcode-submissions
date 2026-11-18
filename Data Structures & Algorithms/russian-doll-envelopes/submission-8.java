class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // Time: O(nlogn)
        // Space: O(n)

        int n = envelopes.length;

        Arrays.sort(envelopes, (a,b) -> {
            int result = Integer.compare(a[0], b[0]);
            if(result != 0) {
                return result;
            }

            return Integer.compare(b[1], a[1]);
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] tails = new int[n];

        int size = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];

            int left = 0;
            int right = size;

            while(left < right) {
                int pivot = (left + right)/2;
                if(tails[pivot] < height) {
                    left = pivot + 1;
                } else {
                    right = pivot;
                }
            }

            tails[left] = height;
            if(left == size) {
                size++;
            }

        }

        return size;
    }
}