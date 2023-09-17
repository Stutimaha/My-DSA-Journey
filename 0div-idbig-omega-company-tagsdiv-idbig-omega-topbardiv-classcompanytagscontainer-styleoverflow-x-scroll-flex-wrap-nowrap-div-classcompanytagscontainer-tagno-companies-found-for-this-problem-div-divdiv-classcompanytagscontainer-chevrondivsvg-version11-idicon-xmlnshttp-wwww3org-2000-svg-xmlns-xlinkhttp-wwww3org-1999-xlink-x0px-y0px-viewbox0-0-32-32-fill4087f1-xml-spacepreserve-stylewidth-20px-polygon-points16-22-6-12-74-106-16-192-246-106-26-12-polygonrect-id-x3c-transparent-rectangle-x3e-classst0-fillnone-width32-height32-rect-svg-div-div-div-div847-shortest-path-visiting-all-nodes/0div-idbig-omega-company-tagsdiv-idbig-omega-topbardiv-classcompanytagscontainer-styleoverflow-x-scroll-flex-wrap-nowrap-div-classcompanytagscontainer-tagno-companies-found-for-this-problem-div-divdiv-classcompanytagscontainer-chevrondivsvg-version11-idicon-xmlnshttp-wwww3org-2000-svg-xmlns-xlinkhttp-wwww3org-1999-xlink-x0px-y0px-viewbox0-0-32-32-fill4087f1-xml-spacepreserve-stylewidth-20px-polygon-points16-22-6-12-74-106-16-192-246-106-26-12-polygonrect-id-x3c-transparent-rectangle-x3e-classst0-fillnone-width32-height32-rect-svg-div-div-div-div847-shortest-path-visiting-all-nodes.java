class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        int[][] dp = new int[n][fullMask + 1];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][1 << i] = 0;
            queue.offer(new int[]{i, 1 << i});
        }

        while (!queue.isEmpty()) {
            int[] nodeMask = queue.poll();
            int node = nodeMask[0];
            int mask = nodeMask[1];
            int steps = dp[node][mask];

            if (mask == fullMask) {
                return steps;
            }

            for (int neighbor : graph[node]) {
                int newMask = mask | (1 << neighbor);
                if (dp[neighbor][newMask] == -1) {
                    dp[neighbor][newMask] = steps + 1;
                    queue.offer(new int[]{neighbor, newMask});
                }
            }
        }

        return -1; 
    }
}

