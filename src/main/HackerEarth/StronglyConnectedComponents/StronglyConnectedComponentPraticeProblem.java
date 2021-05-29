import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

/**
 * https://www.hackerearth.com/practice/algorithms/graphs/strongly-connected-components/tutorial/
 *
 * This is the practice problem of the tutorial for Strongly Connected Component.
 * I have implemented Kosaraju's algorithm for the solution.
 */

class TestClass {
    private static String INPUT_REGEX_PATTERN = "\\s+";
    private static Stack<Integer> visitingOrderStack;
    private static List<Integer> connectedComponentList;
    private static Set<Integer> visitedSet;
    private static int evenCount = 0, oddCount = 0;
    public static void main(String args[] ) throws Exception {
        // Write your code here
        int numberOfVertices, numberOfEdges;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();
        String[] strs = lines.trim().split(INPUT_REGEX_PATTERN);
        numberOfVertices = Integer.parseInt(strs[0]);
        numberOfEdges = Integer.parseInt(strs[1]);
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int v=0; v<=numberOfVertices; v++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int e = 0; e<numberOfEdges; e++) {
            lines = br.readLine();
            strs = lines.trim().split(INPUT_REGEX_PATTERN);
            int source = Integer.parseInt(strs[0]);
            int destination = Integer.parseInt(strs[1]);
            adjacencyList.get(source).add(destination);
        }
        visitingOrderStack = new Stack<>();
        visitedSet = new HashSet<>();
        for(int v=1; v<=numberOfVertices; v++) {
            if(!visitedSet.contains(v)) {
                dfsAndFillStackIfRequiredOrPopulateConnectedComponentList(adjacencyList, v, true, null);
            }
        }
        adjacencyList = getTransposeGraph(adjacencyList);
        stronglyConnectedComponent(adjacencyList);
        System.out.println(oddCount - evenCount);
    }
    private static void stronglyConnectedComponent(List<List<Integer>> adj) {
        visitedSet.clear();
        while(!visitingOrderStack.isEmpty()) {
            int currentVertex = (int) visitingOrderStack.pop();
            if(!visitedSet.contains(currentVertex)) {
                List<Integer> connectedComponentList = new ArrayList<>();
                dfsAndFillStackIfRequiredOrPopulateConnectedComponentList(adj, currentVertex, false, connectedComponentList);
                if(connectedComponentList.size() %2 == 0) {
                    evenCount+=connectedComponentList.size();
                } else {
                    oddCount+=connectedComponentList.size();
                }
            }
        }
    }
    /**
     * I am not happy with this method. So, adding description for understanding. This method is
     * doing three tasks (violates SRP!!)
     * 1. Traverse list in DFS manner.
     * 2. If ordering stack needs to be filled, it adds vertex to orderingStack method.
     * 3. As we need to compute length of each connected component, I had to add current node
     *    to connected component result list for computing number of vertices in a CC.
     *
     * @param adj: Adjacency list
     * @param sourceVertex: source vertex
     * @param isStackPushRequired: if true, it signifies ordering stack is required
     *                           for calculating visiting time at the first step
     *                           of algorithm.
     * @param connectedComponentList: isStackRequired and connectedComponentList have
     *                              to be disjoint (this is a bad practice). We should
     *                              not enforce this by documentation. This list will
     *                              contain connected component.
     */
    private static void dfsAndFillStackIfRequiredOrPopulateConnectedComponentList(List<List<Integer>> adj, int sourceVertex, boolean isStackPushRequired, List<Integer> connectedComponentList) {
        if(connectedComponentList != null) {
            connectedComponentList.add(sourceVertex);
        }
        visitedSet.add(sourceVertex);
        for(Integer adjacentVertex: adj.get(sourceVertex)) {
            if(!visitedSet.contains(adjacentVertex)) {
                dfsAndFillStackIfRequiredOrPopulateConnectedComponentList(adj, adjacentVertex, isStackPushRequired, connectedComponentList);
            }
        }
        if(isStackPushRequired) {
            visitingOrderStack.push(sourceVertex);
        }
    }
    private static List<List<Integer>> getTransposeGraph(List<List<Integer>> adj) {
        int V = adj.size();
        List<List<Integer>> transposeGraph = new ArrayList<>();
        for(int i=0; i<V; i++) {
            transposeGraph.add(new ArrayList<>());
        }
        for(int v=0; v<V; v++) {
            for(Integer adjacentVertex: adj.get(v)) {
                transposeGraph.get(adjacentVertex).add(v);
            }
        }
        return transposeGraph;
    }
}
