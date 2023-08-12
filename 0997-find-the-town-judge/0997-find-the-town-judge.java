class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdegrees = new int[n + 1];
        int[] indegrees = new int[n + 1];
        
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            outdegrees[a]++;
            indegrees[b]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (outdegrees[i] == 0 && indegrees[i] == n - 1) {
                return i; 
            }
        }
        
        return -1; 
    }
}
