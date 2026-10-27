class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // Time: O(nlogn)
        // Space: O(n)

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        List<Queue<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> valueToGroup = new HashMap<>();
        groups.add(new LinkedList<>());
        groups.get(0).add(sortedNums[0]);
        valueToGroup.put(sortedNums[0], 0);

        // Create groups
        for(int i = 1; i < sortedNums.length; i++) {
            int prevNum = sortedNums[i-1];
            int num = sortedNums[i];

            if(num - prevNum > limit) {
                groups.add(new LinkedList<>());
            }

            int index = groups.size() - 1;
            groups.get(index).add(num);
            valueToGroup.put(num, index);
        }

        // Create result
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];

            int groupNumber = valueToGroup.get(value);
            result[i] = groups.get(groupNumber).poll();
        }

        return result;
    }
}
