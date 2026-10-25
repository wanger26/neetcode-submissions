class Solution {
    public int[] decrypt(int[] code, int k) {
        // Time: O(n)
        // Space: O(1)
        int n = code.length;
        int sum = 0;

        int[] result = new int[n];
        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                sum += code[i % n];
            }

            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum += code[(i + 1 + k) % n] - code[(i + 1) % n];
            }
        } else {
            k = -k;
            for (int i = 1; i <= k; i++) {
                sum += code[(n-i) % n];
            }

            // [1,2,3]
            //    |
            for (int i = 0; i < n; i++) {
                result[i] = sum;
                sum += code[i] - code[(i - k + n) % n];
            }
        }

        return result;
    }
}
