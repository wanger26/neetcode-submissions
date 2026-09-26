class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int right = 1;
        int result = 0;
        int sign = 0;

        while (right < arr.length) {
            int diff = Integer.compare(arr[right], arr[right-1]);

            if(diff == 0) {
                result = Math.max(result, right - left);
                left = right;
                sign = 0;
            } else if (sign == 0 || (sign == 1 && diff > 0) || (sign == -1 && diff < 0)) {
                sign = diff < 0 ? 1 : -1; 
            } else {
                 result = Math.max(result, right - left);
                left = right - 1;
                sign = diff < 0 ? 1 : -1; 
            }

            right++;
        }

        result = Math.max(result, right - left);

        return result;
    }
}