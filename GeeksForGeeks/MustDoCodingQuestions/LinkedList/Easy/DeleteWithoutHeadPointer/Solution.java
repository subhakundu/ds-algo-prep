class Node {
    int data;
    Node next;
}

/**
 * Question: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it. Two approaches are mentioned.
 *
 * Time Complexity: O(1)
 */
class Solution
{
    void swapData(Node first, Node second) {
        int data = first.data;
        first.data = second.data;
        second.data = data;
    }
    /**
     We can achieve same result by just copying
     Data from next node as well.
     **/
    void copyData(Node toNode, Node fromNode) {
        toNode.data = fromNode.data;
    }
    void deleteNode(Node nodeToBeDeleted)
    {
        // Your code here
        swapData(nodeToBeDeleted, nodeToBeDeleted.next);
        //copyData(nodeToBeDeleted, nodeToBeDeleted.next);
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }
}
