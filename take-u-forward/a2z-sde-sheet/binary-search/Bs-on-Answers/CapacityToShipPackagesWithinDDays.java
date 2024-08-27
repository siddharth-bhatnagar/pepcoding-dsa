/*
 * Blog: https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/
 * Leetcode 1011
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (possible(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] weights, int days, int cap) {
        int n = weights.length;
        int time = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + weights[i] <= cap) {
                sum += weights[i];
            } else {
                time++;
                sum = weights[i];
            }
        }

        return time <= days;
    }
}
