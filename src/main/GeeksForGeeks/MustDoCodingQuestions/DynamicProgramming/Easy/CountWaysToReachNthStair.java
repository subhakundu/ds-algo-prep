package main.GeeksForGeeks.MustDoCodingQuestions.DynamicProgramming.Easy;

/**
 * Problem: https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    private static final int MOD = 1000000007;
    //Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        if(n==1 || n==2) {
            return n;
        }
        int lastToPreviousValue = 1, previousValue = 2;
        int currentValue = 0;
        for(int i=3; i<=n; i++) {
            currentValue = (lastToPreviousValue + previousValue)%MOD;
            lastToPreviousValue = previousValue;
            previousValue = currentValue;
        }
        return currentValue;
    }
}
