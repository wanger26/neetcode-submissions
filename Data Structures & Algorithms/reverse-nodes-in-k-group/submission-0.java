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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1
        // 2 -> 1
        // 3 -> 2 -> 1 |
        // k == 0. node.next --> same algo

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }

        if (k < 2) {
            return head;
        }

        List<ListNode> segmentTails = new ArrayList<>();
        List<ListNode> segmentHeads = new ArrayList<>();
        ListNode currentNode = head;
        int nodesReveresed = 0;
        while (currentNode != null && nodesReveresed + k <= size) {
            segmentTails.add(currentNode);
            ListNode newHead = null;

            for (int i = 0; i < k; i++) {
                ListNode temp = currentNode.next;
                currentNode.next = newHead;
                newHead = currentNode;
                currentNode = temp;
                nodesReveresed++;
            }
            segmentHeads.add(newHead);
        }

        for (int i = 1; i < segmentHeads.size(); i++) {
            segmentTails.get(i - 1).next = segmentHeads.get(i);
        }

        segmentTails.getLast().next = currentNode;


        return segmentHeads.get(0);
    }
}
