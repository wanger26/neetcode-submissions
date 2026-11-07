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
        }

        return result;
    }
}