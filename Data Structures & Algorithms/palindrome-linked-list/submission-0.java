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
        Stack<ListNode> values = new Stack<>();
        ListNode current = head;
        while(current != null) {
            values.add(current);
            current = current.next;
        }

        ListNode front = head;
        while(!values.isEmpty()) {
            ListNode back = values.pop();
            if(front.equals(back)) {
                return true;
            } else if (front.val != back.val) {
                return false;
            }
            front = front.next;
        }

        return true;
    }
}