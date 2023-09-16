class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int left = 0;
        int right = 1000000; 
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isPossible(heights, mid, rows, columns)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean isPossible(int[][] heights, int k, int rows, int columns) {
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            visited[row][col] = true;
            
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns && !visited[newRow][newCol]) {
                    int effort = Math.abs(heights[newRow][newCol] - heights[row][col]);
                    if (effort <= k) {
                        stack.push(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return visited[rows - 1][columns - 1];
    }
}
