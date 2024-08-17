/**
 * Greedy approach will not work here. Intuitively we would want to take the step that uses minimize min energy,
 * but paths which may be costing 0 energy may get skipped in between.
 * 
 * Again, this problem boils down to checking for all paths/ways and then finding the minimum. 
 * 
 * We can use recursion to find all possible paths
 * For each index, we can return the minimum of all stuffs
 */
public class FrogJump {
    
    // O(2^n), O(N)
    public static int recursive(int n, int[] height) {
        if (n == 0) return 0;

        int left = recursive(n - 1, height) + Math.abs(height[n] - height[n-1]);
        int right;
        if (n > 1) {
            right = recursive(n - 2, height) + Math.abs(height[n] - height[n-2]);
        } else right = Integer.MAX_VALUE;

        return Math.min(left, right);
    }

    // O(N), O(N + N)
    public static int memoization(int idx, int[] height, int[] dp) {
        if (idx == 0) return 0;

        if (dp[idx] != -1) return dp[idx];
        int left = memoization(idx - 1, height, dp) + Math.abs(height[idx] - height[idx-1]);
        int right = Integer.MAX_VALUE;
        if (idx > 1) right = memoization(idx - 2, height, dp) + Math.abs(height[idx] - height[idx-2]);

        return dp[idx] = Math.min(left, right);
    }

    // O(N), O(N)
    public static int tabulation(int n, int[] height) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i=1;i<n;i++) {
            int left = dp[i - 1] + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) right = dp[i-2] + Math.abs(height[i] - height[i-2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // Space Optimisation to O(1)
    public static int optimal(int n, int[] height) {
        int prev1 = 0, prev2 = 0;
        
        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(height[i] - height[i-1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) right = prev2 + Math.abs(height[i] - height[i-2]);

            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
    public static void main(String[] args) {
        // n is given in form of 1 based index, stairs are numbered from
        // 1 to n.
        // height[i] represents height of ith step
        // energy for jumping from ith to jth index is abs(height[i] - height[j])

        
    }
}
