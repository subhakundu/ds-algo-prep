package main.GeeksForGeeks.MustDoCodingQuestions.Stack.ParanthesisChecker;

import java.util.Stack;

/**
 * Problem: https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
 * Time Complexity: O(length of String)
 * Space Complexity: O(N) due to stack.
 */
public class Solution
{
    //Function to check if brackets are balanced or not.
    private static boolean isOpeningBraces(char c) {
        return c=='(' || c=='{' || c=='[';
    }
    private static boolean isMatchingClosingBracket(char openingBracket,
                                                    char closingBracket) {
        return ((openingBracket == '(' && closingBracket == ')') ||
                (openingBracket == '{' && closingBracket == '}') ||
                (openingBracket == '[' && closingBracket == ']'));
    }
    static boolean ispar(String inputString)
    {
        Stack<Character> paranthesisHolder = new Stack<>();
        // add your code here
        for(char s: inputString.toCharArray()) {
            if(isOpeningBraces(s)) {
                paranthesisHolder.push(s);
            } else {
                if(paranthesisHolder.isEmpty()) {
                    return false;
                }
                char latest = paranthesisHolder.pop();
                if(isMatchingClosingBracket(latest, s) == false) {
                    return false;
                }
            }
        }
        if(!paranthesisHolder.isEmpty()) {
            return false;
        }
        return true;
    }
}

