package main.GeeksForGeeks.MustDoCodingQuestions.DynamicProgramming.Easy.GetMinimumSquares;

/**
 * Problem: https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1#
 * It is a DP based solution. Another interesting solution is present based on BFS.
 * Worth exploring.
 * Time Complexity: O(N*sqrt(N))
 */
class Solution {
    public int MinSquares(int n) {
        // Code here
        if(n<=3) {
            return n;
        }
        int[] dpArray = new int[n+1];
        Arrays.fill(dpArray, Integer.MAX_VALUE);
        dpArray[0] = 0;
        dpArray[1] = 1;
        dpArray[2] = 2;
        dpArray[3] = 3;
        for(int i=4; i<=n; i++) {
            dpArray[i] = i;
            for(int j=1;j<= Math.ceil(Math.sqrt(i)); j++) {
                if(j*j > i) {
                    break;
                } else {
                    dpArray[i] = Math.min(dpArray[i], 1 + dpArray[i-j*j]);
                }
            }
        }
        return dpArray[n];
    }
}