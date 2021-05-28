/**
 * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(ROWS*COLUMS).
 * Space Complexity: O(ROWS*COLUMS).
 */
class Solution
{
    private static char WATER = '0';
    private static char LAND = '1';
    private static char VISITED_LAND = '2';
    private int[] neighbourXOffsets = {-1, 0, 1, 1, 1, 0, -1, -1};
    private int[] neighbourYOffsets = {-1, -1, -1, 0, 1, 1, 1, 0, -1};
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        // Code here
        int rows = grid.length-1;
        int cols = grid[0].length-1;
        int count = 0;
        for(int i=0; i<=rows; i++) {
            for(int j=0;j<=cols; j++) {
                if(grid[i][j] == WATER || grid[i][j] == VISITED_LAND) {
                    continue;
                }
                DFS(grid, i, j, rows, cols);
                count++;
            }
        }
        return count;
    }
    private boolean isSafe(char[][]grid, int x, int y, int rows, int cols) {
        return (x>=0 && x<=rows) && (y>=0 && y<=cols) && grid[x][y] == LAND;
    }
    private void DFS(char [][]grid, int x, int y, int rows, int cols) {
        if(grid[x][y] != LAND) {
            return;
        }
        grid[x][y] = VISITED_LAND;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(isSafe(grid, x+neighbourXOffsets[i], y+neighbourYOffsets[j], rows, cols)) {
                    DFS(grid, x+neighbourXOffsets[i], y+neighbourYOffsets[j], rows, cols);
                }
            }
        }
    }
}