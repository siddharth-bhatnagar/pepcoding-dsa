import java.util.Arrays;

/**
 * 1D problems
 * Understand if its a DP problem.
 * You maybe asked count total number of ways, min or max, etc
 * 
 * Trick is to figure out that problem can be solved using recursion.
 * Then, try to represent the problem in terms of index.
 * Do all sort of stuff on that index.
 * sum of all stuffs -> count
 * max of all stuffs -> max
 * min of all stuffs -> min
 * 
 */
public class ClimbingStairs {

    // TC -> O(2^n), SC -> O(N)
    public int climbStairsRecursive(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        int l = climbStairs(n - 1);
        int r = climbStairs(n - 2);

        return l+r;
    }

    // TC -> O(N), SC -> O(N + N)
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];
        int l, r;
        if(n-1>0 && dp[n-1] != -1){
            l = dp[n-1];
        } else  l = climbStairs(n - 1);
        
        if (n-2>0 && dp[n-2] != -1) {
            r = dp[n-2];
        } else  r = climbStairs(n - 2);
    
        return l+r;
    }


    // TC -> O(N), SC -> O(1)
    public int climbStairsBest(int n) {
        if (n == 1) return n;
        int a = 1;
        int b = 1;
        for (int i=2;i<=n;i++) {
            int c = a+b;
            a=b;
            b=c;
        }

        return b;
    }
}
