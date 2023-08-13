class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Keep track of visited nodes
        boolean[] visited = new boolean[numCourses];
        // Keep track of nodes in current DFS path
        boolean[] dfsPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, dfsPath, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] dfsPath, int node) {
        visited[node] = true;
        dfsPath[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, dfsPath, neighbor)) {
                    return true;
                }
            } else if (dfsPath[neighbor]) {
                // If the neighbor is in the current DFS path, a cycle is found
                return true;
            }
        }

        // Remove the node from the current DFS path after exploring all neighbors
        dfsPath[node] = false;
        return false;
    }
}
