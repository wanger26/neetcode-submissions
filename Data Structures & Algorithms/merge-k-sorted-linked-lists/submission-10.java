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

        // Time: O(klogk + nlogk) where n is the total number of nodes, and k is the number of lists
        // Space: O(k)
        if(lists.length == 0) {
            return null;
        }

        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a,b) -> lists[a].val - lists[b].val);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                minQueue.add(i);
            }
        }

        ListNode head = new ListNode();
        ListNode current = head;
        while(minQueue.size() > 1) {
            int minIndex = minQueue.poll();
            while(lists[minIndex] != null && !minQueue.isEmpty() && lists[minIndex].val <= lists[minQueue.peek()].val) {
                current.next = lists[minIndex];

                lists[minIndex] = lists[minIndex].next;
                current = current.next;
            }

            if(lists[minIndex] != null) {
                minQueue.add(minIndex);
            }
        }

        if(!minQueue.isEmpty()) {
            current.next = lists[minQueue.poll()];
        }

        return head.next;
    }
}
