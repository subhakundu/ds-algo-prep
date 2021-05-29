/**
 * Problem: https://practice.geeksforgeeks.org/problems/final-destination4628/1
 *
 * This is a mathematical problem. If robot has to
 * reach (a,b), it has to take a+b steps minimum. The
 * excess steps has to be even, so that it can return
 * back to destination. (a,b) can be negative, so I
 * have used abs() for obtaining absolute value.
 *
 * Time Complexity: O(1)
 */
class Solution {
    static int canReach(Long a, Long b, Long x) {
        // code here
        Long totalHorizontalAndVerticalSteps = Math.abs(a)+Math.abs(b);
        Long excessSteps = (x - totalHorizontalAndVerticalSteps);
        return (excessSteps >=0 && excessSteps%2==0) ? 1 : 0;
    }
};