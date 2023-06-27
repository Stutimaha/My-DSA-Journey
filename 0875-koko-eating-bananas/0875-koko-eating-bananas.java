class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 0;
        for(int pile:piles){
            r = Math.max(r, pile);
        }
        
        while (l < r) {
            int m = (l + r) / 2, total = 0;
            for (int p : piles)
                total += Math.ceil((double) p / m);
            if (total > H)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}
