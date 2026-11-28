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
        
        if(k == 1) {
            return head;
        }
        
        int size = 0;
        ListNode current = head;
        while(current != null) {
            size++;
            current = current.next;
        }

        int index = 0;

        ListNode prevTail = new ListNode();
        current = head;
        while(size - index >= k) {
            ListNode newTail = current;
            ListNode prev = null;

            for(int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;

                prev = current;
                current = next;
            }

            if(index == 0) {
                head = prev;
            } else {
                prevTail.next = prev;
            }

            prevTail = newTail;
            index += k;
        }

        if(current != null) {
            prevTail.next = current;
        }

        return head;
    }
}
