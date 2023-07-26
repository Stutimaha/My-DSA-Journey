class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1;
        int right = 10000007; 
        int result = -1;
        
        int hr = (int) Math.ceil(hour);
        if(hr<n){
            return result;
        }
        
        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double totalTime = 0.0;
            
            for (int i = 0; i < n - 1; i++) {
                totalTime += Math.ceil(dist[i] / (double) mid); 
            }
            totalTime += dist[n - 1] / (double) mid;
            
            if (totalTime <= hour) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

