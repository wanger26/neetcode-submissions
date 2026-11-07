class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for(int value : freqMap.values()) {
            if(value == 1) {
                return -1;
            }

            result += (value+2)/3;
            // while(value != 0) {
            //     if(value >= 3 && value - 3*(value/3) == 0 || value - 3*(value/3) > 1) {
            //         result += value/3;
            //         value -= 3*(value/3);
            //     } else if (value > 1) {
            //         result++;
            //         value -= 2;
            //     } else {
            //         return -1;
            //     }
            // }
        }

        return result;
    }
}