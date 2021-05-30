package main.GeeksForGeeks.MustDoCodingQuestions.DynamicProgramming.Easy.NthFibonacciNumber;

/**
 * Problem: https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
 * Time Complexity: O(N)
 */
class Solution {
    private static final long MOD = 1000000007;
    static long nthFibonacci(long n){
        // code here
        if(n <= 2) {
            return 1;
        }
        long previousValue = 1, lastToPrev = 1, current = 0;
        for(int i=3; i<=n; i++) {
            current = (previousValue + lastToPrev)%MOD;
            lastToPrev = previousValue;
            previousValue = current;
        }
        return current;
    }
}