/**
 * https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
 * I have kept the Solution class only. Driver code is ommitted as I don't need
 * it.
 *
 * Time Complexity: O(V + E).
 * Space Complexity: O(V).
 */
class Solution {
    //Function to find number of strongly connected components in the graph.
    private Stack<Integer> visitingOrderStack;
    private Set<Integer> visitedSet;
    private int sccCount;
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        visitingOrderStack = new Stack<>();
        visitedSet = new HashSet<>();
        sccCount = 0;
        for(int i=0; i<V; i++) {
            if(!visitingOrderStack.contains(i)) {
                dfsAndPushToStackIfRequired(adj, i, true);
            }
        }
        adj = getTransposeGraph(adj, V);
        getStronglyConnectedComponents(adj);
        return sccCount;
    }
    private void getStronglyConnectedComponents(ArrayList<ArrayList<Integer>> adj) {
        visitedSet.clear();
        while(!visitingOrderStack.isEmpty()) {
            int v = (int)visitingOrderStack.pop();
            if(!visitedSet.contains(v)) {
                dfsAndPushToStackIfRequired(adj, v, false);
                sccCount++;
            }
        }
    }
    private void dfsAndPushToStackIfRequired(ArrayList<ArrayList<Integer>> adj, int v, boolean pushIntoStack) {
        visitedSet.add(v);
        int n;
        for(Integer i: adj.get(v)) {
            if(!visitedSet.contains(i)) {
                dfsAndPushToStackIfRequired(adj, i, pushIntoStack);
            }
        }
        if(pushIntoStack) {
            visitingOrderStack.push(v);
        }
    }
    private ArrayList<ArrayList<Integer>> getTransposeGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> transposeGraph =
                new ArrayList<>();
        for(int v=0; v<V; v++) {
            transposeGraph.add(new ArrayList<>());
        }
        for (int v = 0; v < V; v++) {
            for(Integer i: adj.get(v)) {
                transposeGraph.get(i).add(v);
            }
        }
        return transposeGraph;
    }
}