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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode current = newHead;

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        int carryOver = 0;
        while(currentL1 != null && currentL2 != null) {
            int value = currentL1.val + currentL2.val + carryOver;
            current.next = new ListNode(value % 10);
            carryOver = value / 10;

            current = current.next;
            currentL1 = currentL1.next;
            currentL2 = currentL2.next;
        }

        ListNode nonEmpty = currentL1 == null ? currentL2 : currentL1;
        while(nonEmpty != null) {
            int value = nonEmpty.val + carryOver;
            current.next = new ListNode(value % 10);
            carryOver = value / 10;

            nonEmpty = nonEmpty.next;
            current = current.next;
        }

        if(carryOver != 0) {
            current.next = new ListNode(carryOver);
        }

        return newHead.next;
    }
}
