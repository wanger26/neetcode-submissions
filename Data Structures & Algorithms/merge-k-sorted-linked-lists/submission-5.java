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
    public ListNode mergeKLists(ListNode[] lists) {

        // Time: O(m*n) where m is the number of lists and n is the total number nodes across every linked list
        // Space: O(1)
        ListNode newListHead = new ListNode();
        ListNode current = newListHead;

        boolean notDone = true;
        while(notDone) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < minValue) {
                    minIndex = i;
                    minValue = lists[i].val;
                }
            }

            if(minIndex == -1) {
                notDone = false;
            } else {
                current.next = lists[minIndex];
                lists[minIndex] = lists[minIndex].next;
                current = current.next;
            }
        }


        return newListHead.next;
    }
}
