class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Time: O(nlogk)
        // Space: O(k)

        int left = 0;
        int right = arr.length-1;

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
            int leftValue = left < 0 ? Integer.MIN_VALUE : arr[left];
            int rightValue = right >= arr.length ? Integer.MAX_VALUE : arr[right];

            if (Math.abs(leftValue - x) <= Math.abs(rightValue - x)) {
                result.add(leftValue);
                left--;
            } else {
                result.add(rightValue);
                right++;
            }
        }

        result.sort((a,b) -> a-b);

        return result;
    }
}