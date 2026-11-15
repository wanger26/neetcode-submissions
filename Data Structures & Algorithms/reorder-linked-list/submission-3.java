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
    public void reorderList(ListNode head) {
        // Time: O(n)
        // Space: O(n)

        if(head == null) {
            return;
        }

        int n = 0;
        ListNode reverse = null;
        ListNode current = head;
        while(current != null) {
            ListNode newReverse = new ListNode(current.val);
            newReverse.next = reverse;
            reverse = newReverse;

            current = current.next;
            n++;
        }

        ListNode merged = head;
        ListNode original = head.next;
        for(int i = 1; i < n; i++) {
            ListNode toInsert;
            if(i % 2 == 0) {
                ListNode temp = original.next;
                toInsert = original;
                original = temp;
            } else {
                ListNode temp = reverse.next;
                toInsert = reverse;
                reverse = temp;
            }
            toInsert.next = null;
            merged.next = toInsert;
            merged = merged.next;
        }
    }
}
