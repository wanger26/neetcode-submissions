class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        // Time: O(n + q)
        // Space: O(n)
        int n = arr.length;
        int q = queries.length;

        int[] preXorArray = new int[n];

        int prevNum = 0;
        for(int i = 0; i < n; i++) {
            preXorArray[i] = (arr[i] ^ prevNum);
            prevNum = preXorArray[i];
        }

        int[] result = new int[q];
        for(int i = 0; i < q; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            if(start == 0) {
                result[i] = preXorArray[end];
            } else {
                result[i] = (preXorArray[start-1] ^ preXorArray[end]);
            }
        }

        return result;
    }
}
