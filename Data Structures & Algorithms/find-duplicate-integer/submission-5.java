class Solution {

    // Time: O(n)
    // Space: O(1)
    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        // Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // Start a new slow pointer while the other slow pointer is in cycle. Slow2 will catch up due to cycle.
        int slow2 = 0;
        while(slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
