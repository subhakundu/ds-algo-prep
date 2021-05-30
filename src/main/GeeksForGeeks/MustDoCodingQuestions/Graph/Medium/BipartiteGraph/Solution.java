/**
 * Problem: https://practice.geeksforgeeks.org/problems/bipartite-graph/1
 * Time Complexity: O(V)
 * Space Complexity: O(V)
 */
class Solution {
    private static final int WHITE_COLORED = 0;
    private static final int BLACK_COLORED = 1;
    private static final int UNCOLORED = -1;

    private Queue<Pair> bfsQueue;
    private int[] colorArray;
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        // Code here
        bfsQueue = new LinkedList<>();
        colorArray = new int[V];
        Arrays.fill(colorArray, UNCOLORED);
        for(int i=0;i<V; i++) {
            if(colorArray[i] != UNCOLORED) {
                continue;
            }
            if(hasSameColoredAdjacentVertex(adj, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean hasSameColoredAdjacentVertex(ArrayList<ArrayList<Integer>>adj, int source) {
        bfsQueue.add(new Pair(source, WHITE_COLORED));
        colorArray[source] = WHITE_COLORED;
        while(!bfsQueue.isEmpty()) {
            Pair currentVertexInfo = bfsQueue.peek();
            bfsQueue.poll();
            int currentVertex = currentVertexInfo.vertex;
            int currentVertexColor = currentVertexInfo.color;
            for(Integer adjacentVertex: adj.get(currentVertex)) {
                if(colorArray[adjacentVertex] != UNCOLORED) {
                    if(colorArray[adjacentVertex] == currentVertexColor) {
                        return true;
                    }
                    continue;
                } else {
                    colorArray[adjacentVertex] =
                            (currentVertexColor == WHITE_COLORED) ? BLACK_COLORED : WHITE_COLORED;
                    bfsQueue.add(new Pair(adjacentVertex, colorArray[adjacentVertex]));
                }
            }
        }
        return false;
    }
    static class Pair {
        int vertex, color;

        Pair(int v, int c) {
            vertex = v;
            color = c;
        }
    }
}