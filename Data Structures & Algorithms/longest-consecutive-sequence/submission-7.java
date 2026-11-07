class Solution {
    public int longestConsecutive(int[] nums) {

        // Time: O(n)
        // Space: O(n)
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int result = 0;
        Set<Integer> used = new HashSet<>();
        for (int num : uniqueNums) {
            if (used.contains(num)) {
                continue;
            }

            used.add(num);
            int current = 1;
            int nextNum = num;
            while (uniqueNums.contains(nextNum + 1)) {
                used.add(nextNum + 1);
                current++;
                nextNum++;
            }

            nextNum = num;
            while (uniqueNums.contains(nextNum - 1)) {
                used.add(nextNum + 1);
                current++;
                nextNum--;
            }

            result = Math.max(result, current);
        }

        return result;
    }
}
