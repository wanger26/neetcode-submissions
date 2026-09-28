class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Time: O(n)
        // Space: O(1)

        if(nums.length == 1) {
            return List.of(nums[0]);
        }

        int threshold = nums.length/3;

        int number1 = 0;
        int number2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int num : nums) {
            if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0 && num != number1) {
                number2 = num;
                count2 = 1;
            } else if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int frequency1 = 0;
        int frequency2 = 0;
        for(int num : nums) {
            if(num == number1) {
                frequency1++;
            } else if (num == number2) {
                frequency2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if(frequency1 > threshold) {
            result.add(number1);
        }

        if(frequency2 > threshold) {
            result.add(number2);
        }

        return result;
    }
}