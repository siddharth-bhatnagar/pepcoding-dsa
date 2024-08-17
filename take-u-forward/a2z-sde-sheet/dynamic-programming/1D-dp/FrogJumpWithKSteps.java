import java.util.Arrays;

/**
 * In FrogJump, the jump steps were already defined.
 * In this problem, we can have variable number of jumps upto k steps.
 * i + 1, i + 2, i + 3, .....i+k
 */
public class FrogJumpWithKSteps {
    
    // memoization, O(N x K), O(N + N)
    public static int f(int idx, int[] height, int k, int[] dp) {
        if (idx == 0) return 0;

        if (dp[idx] != -1) return dp[idx];
        int minEnergy = Integer.MAX_VALUE;
        for (int j=1;j<=k;j++) {
            if (idx - j >= 0) {
                int energy = f(idx-j, height, k, dp) + Math.abs(height[idx] - height[idx-j]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }

        return dp[idx] = minEnergy;
    }

    // tabulation, O(N x K), O(N)
    public static int f(int n, int k, int height[]) {
        int[] dp = new int[n];
        
        dp[0] = 0;
        for (int i=1;i<n;i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j=1;j<=k;j++) {
                if (i-j>=0) {
                    int energy = dp[i-j] + Math.abs(height[i] - height[i-j]);
                    minEnergy = Math.min(minEnergy, energy);
                    dp[i] = minEnergy;
                }
            }
        }

        return dp[n-1];
    }
}
