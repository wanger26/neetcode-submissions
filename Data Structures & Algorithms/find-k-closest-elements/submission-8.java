class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Time: O(logn + klogk)
        // Space: O(logk)

        int left = 0;
        int right = arr.length - 1;

        int xIndex = -1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (arr[pivot] == x) {
                xIndex = pivot;
                break;
            } else if (x < arr[pivot]) {
                // Go left
                right = pivot - 1;
            } else {
                // Go right
                left = pivot + 1;
            }
        }

        if (xIndex != -1) {
            left = xIndex - 1;
            right = xIndex + 1;
        } else {
            // Reset pointers
            int temp = left;
            left = right;
            right = temp;
        }

        while (right - left - 1 < k) {
            if (right >= arr.length || (left >= 0 && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))) {
                left--;
            } else {
                right++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}