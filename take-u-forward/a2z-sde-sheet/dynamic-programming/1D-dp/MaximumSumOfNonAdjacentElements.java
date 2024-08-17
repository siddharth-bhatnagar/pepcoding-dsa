import java.util.Arrays;

/**
 * House Robber I
 * We want to check the sum of all subsequences based on a given condition and then find the max value out of it.
 * We can tweak the pick and not pick technique to achieve this.
 */
public class MaximumSumOfNonAdjacentElements {
    
    // O(2^N), O(N)
    public static int recursive(int[] nums, int idx) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;

        int pick = nums[idx] + recursive(nums, idx - 2);
        int notPick = 0 + recursive(nums, idx - 1);

        return Math.max(pick, notPick);
    }

    // O(N), O(N + N)
    public static int memoized(int[] nums, int idx, int[] dp) {
        if (idx == 0) return nums[0];
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + memoized(nums, idx - 2, dp);
        int notPick = 0 + memoized(nums, idx - 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    // O(N), O(N)
    public static int tabulation(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i=1;i<nums.length;i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[nums.length-1];
    }

    // O(N), O(1)
    public static int spaceOp(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;

        for (int i=1;i<nums.length;i++) {
            int pick = nums[i];
            if (i > 0) pick += prev2;
            int notPick = 0 + prev1;
            
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
    }
}
