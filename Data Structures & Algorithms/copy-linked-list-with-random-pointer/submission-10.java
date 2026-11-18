/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // Time: O(n)
        // Space: O(1)

        if(head == null) {
            return null;
        }

        Node current = head;

        // Interleave
        while(current != null) {
            Node deepCopy = new Node(current.val);
            deepCopy.next = current.next;
            current.next = deepCopy;

            current = deepCopy.next;
        }

        // Add random next
        current = head;
        while(current != null) {
            Node deepCopy = current.next;
            deepCopy.random = current.random == null ? null : current.random.next;

            current = deepCopy.next;
        }

        // 1->1'->2->2'
        // Remove originals
        current = head;
        Node copyHead = head.next;
        Node currentCopy = copyHead;
        while(currentCopy != null) {
            current.next = currentCopy.next;
            currentCopy.next = currentCopy.next == null ? null : currentCopy.next.next;

            currentCopy = currentCopy.next;
            current = current.next;
        }

        return copyHead;
    }
}
