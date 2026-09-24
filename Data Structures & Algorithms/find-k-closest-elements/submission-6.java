class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Time: O(nlogk)
        // Space: O(k)

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

        List<Integer> result = new ArrayList<>();
        if (xIndex != -1) {
            result.add(arr[xIndex]);
            left = xIndex - 1;
            right = xIndex + 1;
        } else {
            // Reset pointers
            int temp = left;
            left = right;
            right = temp;
        }

        while (result.size() < k) {
            
            if (right >= arr.length || (left >= 0 && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
        }

        result.sort((a, b) -> a - b);

        return result;
    }
}