class Solution {
    public boolean hasDuplicate(int[] nums) {

        // Time: O(n)
        // Space: O(1)
        Set<Integer> values = new HashSet<>();
        for(int num : nums) {
            if(!values.add(num)) {
                return true;
            }
        }

        return false;
    }
}