/**
 * Problem: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * Need to maintain an auxiliary data strucure for capturing recursion stack. It will help
 * us in determining if current vertex is being visited in current traversal.
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
class Solution {
    private Set<Integer> visitedSet;
    private Set<Integer> recursionSet;
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        visitedSet = new HashSet<>();
        recursionSet = new HashSet<>();
        for(int i=0; i<V; i++) {
            if(!visitedSet.contains(i)) {
                if(isCyclic(adj, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int source) {
        if(recursionSet.contains(source)) {
            return true;
        }
        if(visitedSet.contains(source)) {
            return false;
        }
        recursionSet.add(source);
        visitedSet.add(source);
        for(Integer adjacentVertex : adj.get(source)) {
            if(isCyclic(adj, adjacentVertex)) {
                return true;
            }
        }
        recursionSet.remove(source);
        return false;
    }
}