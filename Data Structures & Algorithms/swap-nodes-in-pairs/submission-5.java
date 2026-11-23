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
    public ListNode swapPairs(ListNode head) {

        // Time: O(n)
        // Space: O(1)
        if(head == null) {
            return null;
        }

        ListNode result = null;
        ListNode previous = null;
        ListNode current = head;
        while(current != null && current.next != null) {
            ListNode next = new ListNode(current.next.val);
            if(previous == null) {
                result = next;
            } else {
                previous.next = next;
            }
            next.next = new ListNode(current.val);
            previous = next.next;

            current = current.next.next;
        }

        if(current != null && previous != null) {
            previous.next = new ListNode(current.val);
        } else if (previous == null) {
            result = head;
        }

        return result;
    }
}
