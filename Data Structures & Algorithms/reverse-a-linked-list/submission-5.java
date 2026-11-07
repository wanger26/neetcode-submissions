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
    public ListNode reverseList(ListNode head) {

        // Time: O(n)
        // Space: O(1)

        if(head == null) {
            return null;
        }

        ListNode current = null;
        while(head.next != null) {
            ListNode temp = head.next;
            head.next = current;
            current = head;
            head = temp;
        }

        head.next = current;

        return head;
    }
}
