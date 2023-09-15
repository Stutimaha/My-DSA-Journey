class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        
        // Create a list of all possible edges with their Manhattan distances
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, distance});
            }
        }
        
        // Sort the edges in ascending order based on their weights
        edges.sort((a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int minCost = 0;
        int edgeCount = 0;
        
        // Kruskal's algorithm to find the MST
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            int parentU = find(parent, u);
            int parentV = find(parent, v);
            
            if (parentU != parentV) {
                parent[parentU] = parentV;
                minCost += weight;
                edgeCount++;
                
                // If we have connected all vertices, we can break early
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return minCost;
    }
    
    // Helper function to find the parent of a vertex using path compression
    private int find(int[] parent, int node) {
        if (parent[node] == -1) {
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }
}
