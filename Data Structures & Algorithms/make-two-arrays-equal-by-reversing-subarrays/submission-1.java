class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {

        // Time: O(n)
        // Space: O(n)
        Map<Integer, Integer> targetFrequency = new HashMap<>();
        for(int num : target) {
            targetFrequency.put(num, targetFrequency.getOrDefault(num, 0) + 1);
        }

        for(int num : arr) {
            targetFrequency.put(num, targetFrequency.getOrDefault(num, 0) - 1);
        }

        for(int value : targetFrequency.values()) {
            if(value != 0) {
                return false;
            }
        }

        return true;
    }
}
