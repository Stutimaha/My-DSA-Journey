class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int s = spells.length;
        int[] res = new int[s];
        
        for (int j = 0; j < s; j++) {
            int start = 0;
            int end = n - 1;
            
            while (start <= end) {
                int mid = start + (end - start) / 2;
                long product = (long) spells[j] * potions[mid];
                if (product >= success) {
                    end = mid - 1;
                } else {
                    start = mid + 1; 
                }               
            }   
            int count = n - start;
            res[j] = count;
        }
        return res;
    }
}
