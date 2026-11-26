class Solution {
    public int countTriplets(int[] arr) {

        // Time: O(n^2)
        // Space: O(1)
        int n = arr.length;

        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            int xor = arr[i];
            for(int k = i + 1; k < n; k++) {
                xor ^= arr[k];

                if(xor == 0) {
                    result += k - i;
                }
            }
        }

        return result;
    }
}
