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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list2 != null) {
            ListNode smaller;
            if (list1.val < list2.val) {
                smaller = list1;
                list1 = list1.next;
            } else {
                smaller = list2;
                list2 = list2.next;
            }
            current.next = smaller;
            current = current.next;
        }

        if(list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return result.next;
    }
}