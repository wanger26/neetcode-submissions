class Solution {
    public int countTriplets(int[] arr) {

        // Time: O(n^3)
        // Space: O(1)
        int n = arr.length;
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            int leftXor = arr[i];
            for(int j = i+1; j < n; j++) {
                int rightXor = 0;
                for(int k = j; k < n; k++) {
                    rightXor ^= arr[k];

                    if(rightXor == leftXor) {
                        result++;
                    }
                }
                leftXor ^= arr[j];
            }
        }

        return result;
    }
}
