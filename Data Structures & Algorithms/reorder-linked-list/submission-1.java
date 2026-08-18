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

// Time: O(n)
// Space: O(1)
class Solution {
    public void reorderList(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head;

        // Find the middle
        while(fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode list2 = slowNode.next;
        slowNode.next = null;

        // Reverse the List
        ListNode reversedList2 = null;
        while(list2 != null) {
            ListNode temp = list2.next;
            list2.next = reversedList2;
            
            reversedList2 = list2;
            list2 = temp;
        }

        ListNode list1 = head;
        while (reversedList2 != null) {
            ListNode nextList1 = list1.next;
            ListNode nextList2 = reversedList2.next;

            list1.next = reversedList2;
            reversedList2.next = nextList1;

            list1 = nextList1;
            reversedList2 = nextList2;
        }
    }
}
