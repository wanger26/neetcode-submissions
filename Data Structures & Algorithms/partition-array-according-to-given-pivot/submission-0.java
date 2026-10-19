class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int greaterThanNumbers = 0;
        int lessThanNumbers = 0;

        for(int num : nums) {
            if(num < pivot) {
                lessThanNumbers++;
            } else if(num > pivot) {
                greaterThanNumbers++;
            }
        }

        int lessThanIndex = 0;
        int equalIndex = lessThanNumbers;
        int greaterThanIndex = nums.length - greaterThanNumbers;
        int[] result = new int[nums.length];
        for(int num : nums) {
            if(num < pivot) {
                result[lessThanIndex] = num;
                lessThanIndex++;
            } else if (pivot < num) {
                result[greaterThanIndex] = num;
                greaterThanIndex++;
            } else {
                result[equalIndex] = num;
                equalIndex++;
            }
        }
        return result;
    }
}
