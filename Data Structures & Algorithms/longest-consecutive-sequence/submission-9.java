class Solution {
    public int longestConsecutive(int[] nums) {
        // Time: O(n)
        // Space: O(n)
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int result = 0;
        for (int num : uniqueNums) {
            int currentSequence = 1;
            if (!uniqueNums.contains(num - 1)) {
                while (uniqueNums.contains(num + 1)) {
                    currentSequence++;
                    num++;
                }
            }
            result = Math.max(result, currentSequence);
        }

        return result;
    }
}
