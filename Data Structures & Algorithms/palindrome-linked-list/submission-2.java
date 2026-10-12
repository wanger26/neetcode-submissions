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
    public boolean isPalindrome(ListNode head) {

        // Time: O(n)
        // Space: O(1)
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse List
        ListNode reversed = null;
        while(slow != null) {
            ListNode temp = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = temp;
        }

        ListNode front = head;
        ListNode back = reversed;
        while(front != null && back != null) {
            if(front.val != back.val) {
                return false;
            }
            front = front.next;
            back = back.next;
        }

        return true;
    }
}