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
        if(head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        while(current != null && current.next != null) {
            ListNode next = current.next;
            ListNode nextIterationNode = next.next;

            if(previous == null) {
                head = next;
            } else {
                previous.next = next;
            }
            next.next = current;
            current.next = nextIterationNode;
            previous = current;
            current = nextIterationNode;
        }

        return head;
    }
}
