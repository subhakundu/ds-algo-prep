/**
 * https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/#
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(ROW*COLUMN).
 * Space Complexity: O(ROW*COLUMN).
 */
class Solution{
    private static final int EMPTY = 0;
    private static final int UNINFECTED = 1;
    private static final int INFECTED = 2;
    private static final int DONE_INFECTED = 3;
    private static int[] xOffsetofNeighbours = {0, 1, 0, -1};
    private static int[] yOffsetofNeighbours = {-1, 0, 1, 0};
    private int maxTimeTaken = -1;
    public int helpaterp(int[][] hospital) {
        // code here
        int row = hospital.length-1;
        int col = hospital[0].length-1;

        spreadInfectionByBFS(hospital, row, col);
        for(int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if(hospital[i][j] == UNINFECTED) {
                    return -1;
                }
            }
        }
        return maxTimeTaken;
    }
    private void spreadInfectionByBFS(int[][] hospital, int row, int col) {
        Queue<CellStatus> bfsQueue = new LinkedList<>();
        for(int i=0; i<=row; i++) {
            for(int j=0; j<=col; j++) {
                if(hospital[i][j] == INFECTED) {
                    bfsQueue.add(new CellStatus(new Cell(i, j), 0));
                }
            }
        }

        while(!bfsQueue.isEmpty()) {
            CellStatus currentCellStatus = bfsQueue.peek();
            Cell cell = currentCellStatus.cell;
            bfsQueue.remove();
            hospital[cell.cellX][cell.cellY] = DONE_INFECTED;
            int timeTaken = currentCellStatus.timeTaken;
            if(timeTaken > maxTimeTaken) {
                maxTimeTaken = timeTaken;
            }
            for(int i=0; i<4; i++) {
                int nextCellX = cell.cellX+xOffsetofNeighbours[i];
                int nextCellY = cell.cellY+yOffsetofNeighbours[i];
                if(canGetInfectedOrSpread(hospital, nextCellX, nextCellY
                        , row, col)) {
                    if(hospital[nextCellX][nextCellY] != INFECTED) {
                        hospital[nextCellX][nextCellY] = INFECTED;
                        timeTaken += 1;
                    } else {
                        timeTaken = 0;
                    }
                    bfsQueue.add(new CellStatus(new Cell(nextCellX, nextCellY), timeTaken));
                }
            }
        }
        return;
    }
    private boolean canGetInfectedOrSpread(int[][] hospital, int x, int y, int row, int col) {
        return valueInRange(x, 0, row) && valueInRange(y, 0, col)
                && (hospital[x][y] == UNINFECTED || hospital[x][y] == INFECTED);
    }
    private boolean valueInRange(int value, int left, int right) {
        return (value>=left && value<=right);
    }
    class CellStatus {
        Cell cell;
        int timeTaken;

        public CellStatus(Cell cell, int t) {
            this.cell = cell;
            timeTaken = t;
        }
    }
    class Cell {
        int cellX;
        int cellY;
        public Cell(int x, int y) {
            cellX = x;
            cellY = y;
        }
    }
}