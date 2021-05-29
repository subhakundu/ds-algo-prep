class Node {
    int data;
    Node next;
}

/**
 * Question: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(N) where N = length of the List.
 */
class Solution {
    Node reverseList(Node head) {
        Node result = null, current = head, next = null;
        while(current != null) {
            next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }
}

