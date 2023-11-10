class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            adjList.computeIfAbsent(pair[0], key -> new ArrayList<>()).add(pair[1]);
            adjList.computeIfAbsent(pair[1], key -> new ArrayList<>()).add(pair[0]);
        }

        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();

        int start = 0;
        for (int key : adjList.keySet()) {
            if (adjList.get(key).size() == 1) {
                start = key;
                break;
            }
        }

        dfs(adjList, result, visited, start, 0);

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> adjList, int[] result, Set<Integer> visited, int current, int index) {
        result[index] = current;
        visited.add(current);

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(adjList, result, visited, neighbor, index + 1);
            }
        }
    }
}
