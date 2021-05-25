class Node {
    int data;
    Node next;
}
/**
 * https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(N + M) where N, M = length of the Lists.
 * Space Complexity: O(N + M) for stack sizes.
 */
class Solution{
    //Function to add two numbers represented by linked list.
    static Stack<Integer> getStackRepresentation(Node list) {
        Stack<Integer> stackRepresentation = new Stack<Integer>();
        while(list!=null) {
            stackRepresentation.add(list.data);
            list = list.next;
        }
        return stackRepresentation;
    }
    static Node getNewNodeAndAdjustResult(int data, Node result) {
        Node temp = new Node(data);
        if(result == null) {
            result = temp;
        } else {
            temp.next = result;
            result = temp;
        }
        return result;
    }
    static Node addTwoLists(Node first, Node second){
        Stack<Integer> firstList = getStackRepresentation(first);
        Stack<Integer> secondList = getStackRepresentation(second);
        Node result = null;
        int carry = 0, additionResult, remainder;
        while(!firstList.isEmpty() && !secondList.isEmpty()) {
            int firstValue = firstList.pop();
            int secondValue = secondList.pop();
            additionResult = (firstValue + secondValue + carry);
            carry = additionResult/10;
            remainder = additionResult%10;
            result = getNewNodeAndAdjustResult(remainder, result);
        }
        Stack<Integer> finalList = null;
        if(!firstList.isEmpty()) {
            finalList = firstList;
        } else if(!secondList.isEmpty()) {
            finalList = secondList;
        }
        while(finalList != null && !finalList.isEmpty()) {
            int value = finalList.pop();
            additionResult = (value + carry);
            carry = additionResult/10;
            remainder = additionResult%10;
            result = getNewNodeAndAdjustResult(remainder, result);
        }
        if(carry>0) {
            result = getNewNodeAndAdjustResult(carry, result);
        }
        return result;
    }
}
