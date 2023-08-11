class Solution {
    public boolean validPath(int totalNodes, int[][] connections, int startNode, int endNode) {
        List<List<Integer>> graph = buildGraph(totalNodes, connections);
        boolean[] visited = new boolean[totalNodes];
        return dfs(graph, visited, startNode, endNode);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int currentNode, int endNode) {
        if (currentNode == endNode) {
            return true; 
        }

        visited[currentNode] = true;

        for (int neighbor : graph.get(currentNode)) {
            if (!visited[neighbor] && dfs(graph, visited, neighbor, endNode)) {
                return true; 
            }
        }

        return false; 
    }

   private List<List<Integer>> buildGraph(int totalNodes, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < totalNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
