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
    public ListNode insertionSortList(ListNode head) {

        // Time: O(n^2)
        // Space: O(1)
        ListNode dummy = new ListNode(0);

        ListNode current = head;
        while(current != null) {
            ListNode nextNode = current.next;

            ListNode prev = dummy;
            ListNode node = dummy.next;
            while(node != null && current.val > node.val) {
                prev = node;
                node = node.next;
            }

            prev.next = current;
            current.next = node;

            current = nextNode;
        }

        return dummy.next;
    }
}