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

    // Time: O(n)
    // Space: O(1)
    public Node copyRandomList(Node head) {

        if(head == null) {
            return null;
        }

        // Pass 1 - Interleave
        Node currentNode = head;
        while(currentNode != null) {
            Node clone = new Node(currentNode.val);
            clone.next = currentNode.next;
            currentNode.next = clone;

            currentNode = clone.next;
        }

        // Pass 2 - Get the ranomds set
        currentNode = head;
        while(currentNode != null) {
            Node clone = currentNode.next;

            if(currentNode.random != null) {
                clone.random = currentNode.random.next;
            }

            currentNode = clone.next;
        }

        // Pass 3 - Create its own list
        Node original = head;
        Node newHead = head.next;
        Node clone = newHead;
        while(original != null) {
            original.next = original.next.next;
            original = original.next;
            if(original != null) {
                clone.next = original.next;
                clone = clone.next;
            }
        }

        return newHead;

    }
}
