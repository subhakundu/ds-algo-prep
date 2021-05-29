class Node {
    int data;
    Node next;
}
/**
 * Question: https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(N) where N = length of the List.
 */
class Solution
{
    int getMiddle(Node head)
    {
        Node slow = head, fast = head;
        while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
