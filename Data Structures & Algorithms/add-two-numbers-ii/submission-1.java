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

        // Time: O(n+m)
        // Space: O(1)
        ListNode l1Reversed = reverse(l1);
        ListNode l2Reversed = reverse(l2);

        int remainder = 0;
        ListNode sumNode = null;
        while(l1Reversed != null && l2Reversed != null) {
            int sum = l1Reversed.val + l2Reversed.val + remainder;
            int value = sum % 10;
            remainder = sum / 10;

            ListNode newNode = new ListNode(value);
            newNode.next = sumNode;
            sumNode = newNode;

            l1Reversed = l1Reversed.next;
            l2Reversed = l2Reversed.next;
        }

        ListNode remaningNode = l1Reversed == null ? l2Reversed : l1Reversed;

        while(remaningNode != null) {
            int sum = remaningNode.val + remainder;
            int value = sum % 10;
            remainder = sum / 10;

            ListNode newNode = new ListNode(value);
            newNode.next = sumNode;
            sumNode = newNode;

            remaningNode = remaningNode.next;
        }

        if(remainder != 0) {
            ListNode newNode = new ListNode(1);
            newNode.next = sumNode;
            sumNode = newNode;
        }

        return sumNode;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}