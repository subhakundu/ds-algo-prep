class Node {
    int data;
    Node next;
}
/**
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it. It can be done with reversing second part and comparing as well.
 *
 * Time Complexity: O(N) where N = length of the List.
 * Space Complexity: O(N) considering function call stack.
 */
class Solution
{
    Node left;
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head)
    {
        left = head;
        return isPalindromeUtil(head);
    }
    boolean isPalindromeUtil(Node right) {
        if(right == null) {
            return true;
        }
        boolean isPalindromeSubList = isPalindromeUtil(right.next);
        if(!isPalindromeSubList) {
            return isPalindromeSubList;
        }
        isPalindromeSubList = (left.data == right.data);
        left = left.next;
        return isPalindromeSubList;
    }
}
