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
        Map<Node, Node> originalToDeepCopy = new HashMap<>();
        Node currentNode = head;
        while(currentNode != null) {
            Node newNode = new Node(currentNode.val);
            originalToDeepCopy.put(currentNode, newNode);

            currentNode = currentNode.next;
        }

        currentNode = head;
        while(currentNode != null) {
            Node deepCopy = originalToDeepCopy.get(currentNode);

            if(currentNode.next != null) {
                deepCopy.next = originalToDeepCopy.get(currentNode.next);
            }

            if(currentNode.random != null) {
                deepCopy.random = originalToDeepCopy.get(currentNode.random);
            }

            currentNode = currentNode.next;
        }

        return originalToDeepCopy.get(head);
    }
}
