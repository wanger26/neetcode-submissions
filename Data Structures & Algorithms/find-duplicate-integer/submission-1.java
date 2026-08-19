class Solution {

    // Time: O(n)
    // Space: O(n)
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
    }
}
