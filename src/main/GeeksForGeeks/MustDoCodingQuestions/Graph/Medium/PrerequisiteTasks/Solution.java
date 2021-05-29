/**
 * Problem: https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/?track=amazon-graphs&batchId=192
 * This problem is same as detecting loop in directed graph. I have used YES/NO in main method to denote if all tasks
 * are possible to finish or not.
 * V: number of courses (i.e., nodes)
 * E: number of relations (i.e., edges)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 */
class Solution {
    private static final boolean YES = true;
    private static final boolean NO = false;
    private List<List<Integer>> adjacencyList;
    private Set<Integer> visitedSet;
    private Set<Integer> recursionSet;
    public boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        adjacencyList = new ArrayList<>();
        visitedSet = new HashSet<>();
        recursionSet = new HashSet<>();
        for(int i=0; i<N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i=0; i<N; i++) {
            if(!visitedSet.contains(i)) {
                if(hasDependencyLoop(adjacencyList, i)) {
                    return NO;
                }
            }
        }
        return YES;
    }
    private boolean hasDependencyLoop(List<List<Integer>> adjacencyList, int source) {
        if(recursionSet.contains(source)) {
            return true;
        }
        if(visitedSet.contains(source)) {
            return false;
        }
        recursionSet.add(source);
        visitedSet.add(source);
        for(Integer adjacentVertex: adjacencyList.get(source)) {
            if(hasDependencyLoop(adjacencyList, adjacentVertex)) {
                return true;
            }
        }
        recursionSet.remove(source);
        return false;
    }

}