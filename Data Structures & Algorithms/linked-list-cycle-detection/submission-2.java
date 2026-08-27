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

    // Time: O(n)
    // Space: O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;


        while(fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }


        if (fast == null || fast.next == null) {
            return false;
        }

        return true;
    }
}
