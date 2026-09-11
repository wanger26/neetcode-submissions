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

    // Time: O(m+n)
    // Space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode current = newHead;

        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode node1 = l1;
            ListNode node2 = l2;

            int sum = node1.val + node2.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;

            current = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            ListNode node1 = l1;

            int sum = node1.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;

            current = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            ListNode node2 = l2;

            int sum = node2.val + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;

            current = newNode;
            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(1);
            current.next = newNode;
        }

        return newHead.next;
    }
}
