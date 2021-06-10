// Leetcode 1870

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int lo = 1;
        int hi = 10000000;

        int speed = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            double totalTime = 0;
            for (int i = 0; i < n - 1; i++) {
                double time = Math.ceil((double) dist[i] / mid);
                totalTime += time;
            }
            totalTime += (double) dist[n - 1] / mid;

            if (totalTime > hour) {
                lo = mid + 1;
            } else {
                speed = mid;
                hi = mid - 1;
            }
        }

        return speed;
    }
}

// O(nlogk), O(1)