/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = head;
        ListNode twin = reverse(slow);
        int result = 0;
        while(twin != null) {
            result = Math.max(result, twin.val + current.val);
            twin = twin.next;
            current = current.next;
        }

        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }
        return prev;
    }
}