class Solution {

    // Time: O(n^2)
    // Space: O(n)
    
    public int lengthOfLIS(int[] nums) {
        // Bottom Up

        int n = nums.length;
        int[] tails = new int[n];
        int tailsIndex = 0;
        for(int num : nums) {

            // If the current biggest tail is less than our current number, we can extend it
            if(tailsIndex == 0 || tails[tailsIndex-1] < num) {
                tails[tailsIndex] = num;
                tailsIndex++;
            } else {
                // Our current number is less than the biggest tail. BS for number that is the first element bigger than current number
                int left = 0;
                int right = tailsIndex-1;

                while(left < right) {
                    int pivot = left + (right-left)/2;
                    // Go left
                    if(num <= tails[pivot]) {
                        right = pivot;
                    } else {
                        left = pivot + 1;
                    }
                }

                // Now replace the first element that is bigger than current num
                tails[left] = num;
            }
        }

        return tailsIndex;
    }
}
