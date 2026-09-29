/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        Map<Integer, Integer> cache = new HashMap<>();
        int peak = 0;
        int left = 1;
        int right = mountainArr.length() - 2;

        // Find the peak
        while(left < right) {
            int pivot = left + (right-left)/2;

            if(!cache.containsKey(pivot)) {
                cache.put(pivot, mountainArr.get(pivot));
            }
            if(!cache.containsKey(pivot+1)) {
                cache.put(pivot+1, mountainArr.get(pivot+1));
            }

            int pivotValue = cache.get(pivot);
            int pivotNeighborValue = cache.get(pivot+1);

            // Increasing slope --> try and extend it
            if(pivotValue < pivotNeighborValue) {
                peak = pivot+1;
                left = pivot+1;
            } else {
                // Else we are going down hill already so peak may be on left
                peak = pivot;
                right = pivot;
            }
        }

        // Try binary search left of peak
        left = 0;
        right = peak;
        while(left <= right) {
            int pivot = left + (right-left)/2;

            if(!cache.containsKey(pivot)) {
                cache.put(pivot, mountainArr.get(pivot));
            }

            int value = cache.get(pivot);
            if(value == target) {
                return pivot;
            } else if (target < value) {
                right = pivot-1;
            } else {
                left = pivot + 1;
            }
        }

         // Try binary search right of peek
        left = peak + 1;
        right = mountainArr.length() - 1;
        while(left <= right) {
            int pivot = left + (right-left)/2;
            if(!cache.containsKey(pivot)) {
                cache.put(pivot, mountainArr.get(pivot));
            }
            int value = cache.get(pivot);
            if(value == target) {
                return pivot;
            } else if (target < value) {
                // Go right --> since right of peek is in decreasing order
                left = pivot+1;
            } else {
                right = pivot -1;
            }
        }


        return -1;
    }

}