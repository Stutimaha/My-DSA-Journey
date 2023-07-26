class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1;
        int right = 10000007;

        if (hour < n - 1) {
            return -1;
        }

        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            double totalTime = 0.0;

            for (int i = 0; i < n - 1; i++) {
                totalTime += Math.ceil(dist[i] / (double) mid);
            }
            totalTime += dist[n - 1] / (double) mid;

            if (totalTime <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Check if the last found speed allows you to arrive on time
        double totalTime = 0.0;
        for (int i = 0; i < n - 1; i++) {
            totalTime += Math.ceil(dist[i] / (double) left);
        }
        totalTime += dist[n - 1] / (double) left;

        return totalTime <= hour ? left : -1;
    }
}
