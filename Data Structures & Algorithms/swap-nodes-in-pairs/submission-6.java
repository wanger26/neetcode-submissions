
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Time: O(n)
        // Space: O(n)
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (head != null && head.next != null) {
            tail.next = new ListNode(head.next.val);
            tail = tail.next;

            tail.next = new ListNode(head.val);
            tail = tail.next;

            head = head.next.next;
        }

        if (head != null) {
            tail.next = new ListNode(head.val);
        }

        return dummy.next;
    }
}
