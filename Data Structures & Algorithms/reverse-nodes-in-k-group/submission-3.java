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
        int nodes = 0;
        ListNode current = head;
        while (current != null && nodes < k) {
            nodes++;
            current = current.next;
        }

        if (nodes == k) {
            current = reverseKGroup(current, k);
            while (nodes > 0) {
                nodes--;
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
            }
            head = current;
        }
        return head;
    }
}
