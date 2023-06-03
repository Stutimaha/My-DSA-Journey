class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> subordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subordinates.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates.get(manager[i]).add(i);
            }
        }
        
        return dfs(headID, subordinates, informTime);
    }
    
    private int dfs(int employee, List<List<Integer>> subordinates, int[] informTime) {
        int maxTime = 0;
        for (int subordinate : subordinates.get(employee)) {
            maxTime = Math.max(maxTime, dfs(subordinate, subordinates, informTime));
        }
        
        return maxTime + informTime[employee];
    }
}
