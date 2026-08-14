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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prevNodeToRemove = null;
        ListNode currentNode = head;
        for(int i = 0; i < n; i++) {
            currentNode = currentNode.next;
        }

        while(currentNode != null) {
            if (prevNodeToRemove == null) {
                prevNodeToRemove = head;
            } else {
                prevNodeToRemove = prevNodeToRemove.next;
            }
            currentNode = currentNode.next;
        }

        if (prevNodeToRemove == null) {
            return head.next;
        }

        prevNodeToRemove.next = prevNodeToRemove.next.next;

        return head;
    }
}
