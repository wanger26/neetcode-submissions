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
        Map<Node, Node> originalToNew = new HashMap<>();
        
        Node current = head;
        while(current != null) {
            originalToNew.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while(current != null) {
            Node newNode = originalToNew.get(current);
            newNode.next = current.next == null ? null : originalToNew.get(current.next);
            newNode.random = current.random == null ? null : originalToNew.get(current.random);

            current = current.next;
        }

        return originalToNew.get(head);
    }
}
