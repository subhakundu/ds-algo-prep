class Node {
    int data;
    Node next;
}
/**
 * Question: https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(N + M) where N and M = length of the Lists.
 */
class Solution {
    //Function to merge two sorted linked list.
    Node sortedMerge(Node head1, Node head2) {
        // This is a "method-only" submission.
        // You only need to complete this method
        Node resultHead = null, resultTail = null, tempResult = null;
        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
                tempResult = head1;
                head1 = head1.next;
            } else {
                tempResult = head2;
                head2 = head2.next;
            }
            if(resultHead == null) {
                resultHead = tempResult;
                resultTail = resultHead;
            } else {
                resultTail.next = tempResult;
                resultTail = resultTail.next;
            }
        }
        if(head1 == null) {
            resultTail.next = head2;
        } else {
            resultTail.next = head1;
        }
        return resultHead;
    }
}