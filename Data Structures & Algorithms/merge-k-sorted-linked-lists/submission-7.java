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
        // Time: O(nlogm) where m is the number of lists and n is the total number nodes across every
        // linked list Space: O(m)
        ListNode newListHead = new ListNode();
        ListNode current = newListHead;

        boolean notDone = true;
        PriorityQueue<ListNode> minNodeQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minNodeQueue.add(lists[i]);
            }
        }

        while (!minNodeQueue.isEmpty()) {
            ListNode minNode = minNodeQueue.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                minNodeQueue.add(minNode.next);
            }
        }

        return newListHead.next;
    }
}
