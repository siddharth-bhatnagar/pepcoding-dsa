/*
 * Blog: https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
 * Posted on SPOJ originally, but similar to Leetcode 1552
 */

import java.util.Arrays;

public class AggressiveCows {
    // O(NlogN) + O(log (max - min + 1)) + N, O(1)
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n - 1] - position[0];
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(position, m, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean possible(int[] position, int balls, int min) {
        int countBalls = 1;
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            int force = position[i] - last;
            if (force >= min) {
                countBalls++;
                last = position[i];
            }

            if (countBalls >= balls) return true;
        }

        return false;
    }
}
