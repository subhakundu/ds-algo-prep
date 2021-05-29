/**
 * Problem: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?track=DSASP-Graph&batchId=155
 * For this problem, we need to check if any adjacent (not the parent vertex) is already visited or not.
 * Solution is based on DFS.
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 */
class Solution {
    //Function to detect cycle in an undirected graph.
    private Set<Integer> visitedSet;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visitedSet = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(visitedSet.contains(i)) {
                continue;
            }
            if(isCyclic(adj, i, V, -1)) {
                return true;
            }
        }
        return false;
    }
    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int source, int V, int parent) {
        visitedSet.add(source);
        for(Integer adjacent: adj.get(source)) {
            if(visitedSet.contains(adjacent)) {
                if(adjacent != parent) {
                    return true;
                }
                continue;
            }
            if(isCyclic(adj, adjacent, V, source)) {
                return true;
            }
        }
        return false;
    }
}