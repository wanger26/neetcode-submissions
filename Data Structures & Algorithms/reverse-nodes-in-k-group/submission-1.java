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
    public ListNode reverseKGroup(ListNode head, int k) {

        // Time: O(n)
        // Space: O(1)

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        if (k < 2) {
            return head;
        }

        int nodesReveresed = 0;
        ListNode currentNode = head;
        ListNode dummy = new ListNode();
        ListNode previousTail = dummy;
        while (currentNode != null && nodesReveresed + k <= size) {
            ListNode nextTail = currentNode;
            ListNode newHead = null;

            for (int i = 0; i < k; i++) {
                ListNode temp = currentNode.next;
                currentNode.next = newHead;
                newHead = currentNode;
                currentNode = temp;
                nodesReveresed++;
            }
            previousTail.next = newHead;
            previousTail = nextTail;
        }

        if(currentNode != null) {
            previousTail.next = currentNode;
        }


        return dummy.next;
    }
}
