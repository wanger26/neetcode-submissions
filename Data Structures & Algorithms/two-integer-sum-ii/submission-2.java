class Solution {

    // Time: O(n)
    // Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left++; // We need to increase our sum
            } else {
                right--;
            }
        }

        throw new IllegalArgumentException("There must be exactly one valid solution");
    }
}
