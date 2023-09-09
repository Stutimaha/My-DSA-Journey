import java.util.*;

public class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] sortedEdges = new int[m][4]; 
        for (int i = 0; i < m; i++) {
            sortedEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(sortedEdges, (a, b) -> Integer.compare(a[2], b[2]));

        int mstWeight = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int[] edge = sortedEdges[i];
            int u = edge[0], v = edge[1], weight = edge[2], index = edge[3];

            if (uf.union(u, v)) {
                mstWeight += weight;
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] edge = edges[sortedEdges[i][3]]; 
            int u = edge[0], v = edge[1], weight = edge[2];

            int newMSTWeight = 0;
            UnionFind ufWithoutEdge = new UnionFind(n);
            for (int j = 0; j < m; j++) {
                if (i != j) {
                    int[] e = edges[sortedEdges[j][3]];
                    int uu = e[0], vv = e[1], ww = e[2];
                    if (ufWithoutEdge.union(uu, vv)) {
                        newMSTWeight += ww;
                    }
                }
            }
            if (newMSTWeight != mstWeight) {
                critical.add(sortedEdges[i][3]);
                continue;
            }

            ufWithoutEdge = new UnionFind(n);
            ufWithoutEdge.union(u, v);
            newMSTWeight = weight;
            for (int j = 0; j < m; j++) {
                if (i != j) {
                    int[] e = edges[sortedEdges[j][3]];
                    int uu = e[0], vv = e[1], ww = e[2];
                    if (ufWithoutEdge.union(uu, vv)) {
                        newMSTWeight += ww;
                    }
                }
            }
            if (newMSTWeight == mstWeight) {
                pseudoCritical.add(sortedEdges[i][3]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);
        result.add(pseudoCritical);
        return result;        
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false; 
            }
            parent[rootX] = rootY;
            return true;
        }
    }
}
