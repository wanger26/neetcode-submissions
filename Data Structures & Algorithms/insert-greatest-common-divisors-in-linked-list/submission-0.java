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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode previousNode = head;
        ListNode currentNode = previousNode.next;

        while(currentNode != null) {
            previousNode.next = new ListNode(gcd(previousNode.val, currentNode.val), currentNode);
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return head;
    }

    private int gcd(int num1, int num2) {
        if(num1 == 0 || num2 == 0) {
            return num1 == 0 ? num2 : num1;
        }

        return gcd(num2, num1 % num2);
    }
}