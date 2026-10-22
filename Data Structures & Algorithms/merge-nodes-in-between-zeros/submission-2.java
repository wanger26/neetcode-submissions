class Solution {
    public ListNode mergeNodes(ListNode head) {

        // Time: O(n)
        // Space: O(1)
        ListNode write = head;
        ListNode current = head.next;
        int sum = 0;

        while (current != null) {
            if (current.val == 0) {
                write = write.next;
                write.val = sum;
                sum = 0;
            } else {
                sum += current.val;
            }

            current = current.next;
        }

        write.next = null;
        return head.next;
    }
}