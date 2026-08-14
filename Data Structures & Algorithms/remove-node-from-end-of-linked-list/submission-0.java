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
        int size = getSize(head);
        int removeIndex = size - n;

        if (removeIndex == 0) {
            return head.next;
        }

        ListNode currentNode = head;
        for (int i=0; i < removeIndex -1; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    private int getSize(ListNode node) {
        int counter = 0;
        while(node != null) {
            counter++;
            node = node.next;
        }

        return counter;
    }
}
