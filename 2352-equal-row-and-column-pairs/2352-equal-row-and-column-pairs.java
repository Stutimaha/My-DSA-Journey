class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int[] row: grid){
            String s = Arrays.toString(row);
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        for (int i = 0; i<grid[0].length;i++){
            int[] col = new int[grid[0].length];
            for (int j = 0; j<grid.length;j++){
                col[j] = grid[j][i];
            }
                String k = Arrays.toString(col);
                count+=map.getOrDefault(k,0);
        }
        return count;
    }
}