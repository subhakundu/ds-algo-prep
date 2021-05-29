/**
 * Problem: https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
 * Solution Approach: DFS from valid cell and marking it visted in place.
 *
 * Time Complexity: O(Row*Col)
 * Space Complexity: O(result) where result: max area with 1.
 * I have not taken any auxilary space. I have modified the cell
 * value. If grid is immutable, it will require O(row*col) for
 * keeping a visited 2D array.
 */
class Solution {
    private static final int INVALID_CELL = 0;
    private static final int VALID_CELL = 1;
    private static final int VISITED_CELL = 2;
    private int[] neighborXOffset = {-1, 0, 1, 1, 1, 0, -1, -1};
    private int[] neighborYOffset = {-1, -1, -1, 0, 1, 1, 1, 0};
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        // Code here
        int row = grid.length, col = grid[0].length, max = Integer.MIN_VALUE;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == VALID_CELL) {
                    int count = dfsToCalculateArea(grid, i, j, row, col);
                    if(max < count) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
    private boolean isSafe(int[][] grid, int x, int y, int row, int col) {
        return (x>=0 && x<row) && (y>=0 && y<col) && (grid[x][y] == VALID_CELL);
    }
    private int dfsToCalculateArea(int[][] grid, int x, int y, int row, int col) {
        // System.out.println("First: " + x + ":" + y + " " + count);
        // System.out.println("Second: " + x + ":" + y);
        grid[x][y] = VISITED_CELL;
        int countResult = 1;
        for(int i=0; i<8; i++) {
            int adjacentCellXCoor = x + neighborXOffset[i];
            int adjacentCellYCoor = y + neighborYOffset[i];
            if(isSafe(grid, adjacentCellXCoor, adjacentCellYCoor, row, col)) {
                countResult += dfsToCalculateArea(grid, adjacentCellXCoor, adjacentCellYCoor,
                        row, col);
            }
        }
        return countResult;
    }
}