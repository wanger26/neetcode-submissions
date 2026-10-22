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
    public ListNode mergeNodes(ListNode head) {
        ListNode base = null;
        int currentSum = 0;

        ListNode current = head;
        while(current != null) {
            if(current.val == 0) {
                if(base == null) {
                    base = current;
                } else {
                    base.val = currentSum;
                    currentSum = 0;

                    if(current.next == null) {
                        base.next = null;
                    } else {
                        base.next = current;
                    }
                    base = current;
                }
            }
            currentSum += current.val;
            current = current.next;
        }

        return head;
    }
}
