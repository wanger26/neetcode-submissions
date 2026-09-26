class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // Time: O(n)
        // Space: O(1)
        int count = 0;
        int result = 0;
        int sign = 0;

        for (int i = 1; i < arr.length; i++) {
            int diff = Integer.compare(arr[i], arr[i - 1]);

            if (diff == 0) {
                result = Math.max(result, count);
                count = 0;
                sign = 0;
            } else if (sign == 0 || (sign == 1 && diff > 0) || (sign == -1 && diff < 0)) {
                sign = diff < 0 ? 1 : -1;
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
                sign = diff < 0 ? 1 : -1;
            }
        }

        result = Math.max(result, count);

        return result + 1;
    }
}