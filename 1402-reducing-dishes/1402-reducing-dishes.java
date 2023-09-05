class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        
        int best = 0;
        int sum = 0;
        int totalSum = 0; 
        
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            totalSum += sum;
            best = Math.max(best, totalSum);
        }
        
        return best;
    }
}
