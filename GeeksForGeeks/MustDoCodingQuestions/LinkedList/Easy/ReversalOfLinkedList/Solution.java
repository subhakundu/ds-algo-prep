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

