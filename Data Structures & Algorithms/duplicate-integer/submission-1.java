class Solution {

    // Time: O(n)
    // Space: O(n)
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) {
            if(!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}