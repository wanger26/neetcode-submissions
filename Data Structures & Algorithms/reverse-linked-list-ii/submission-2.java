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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Time: O(n)
        // Space: O(1)
        ListNode currentNode = head;
        ListNode tailOfLeftUnreversedList = null;
        ListNode reversedListHead = null;

        int index = 1;
        while(index < left) {
            tailOfLeftUnreversedList = currentNode;
            currentNode = currentNode.next;
            index++;
        }

        ListNode reversedListTail = currentNode;
        while(index <= right) {
            ListNode nextNode = currentNode.next;

            currentNode.next = reversedListHead;
            reversedListHead = currentNode;

            currentNode = nextNode;
            index++;
        }

        // Connected reversed list with start
        if(tailOfLeftUnreversedList != null) {
            tailOfLeftUnreversedList.next = reversedListHead;
        }

        // Connect reversed list with end
        ListNode headOfRightUnreversedList = currentNode;
        reversedListTail.next = headOfRightUnreversedList;

        return left == 1 ? reversedListHead : head;
    }
}