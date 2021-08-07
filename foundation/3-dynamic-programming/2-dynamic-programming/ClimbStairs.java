import java.util.*;

public class ClimbStairs {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int a1 = countPathsBrute(n);
        int a2 = countPathsMemoized(n, new int[n + 1]);
        int a3 = countPathsTab(n);

        System.out.println(a3);
        scn.close();
    }

    public static int countPathsBrute(int n) {
        if(n<0) return 0;

        if (n == 0 || n == 1)
            return 1;

        int x = countPathsBrute(n - 1);
        int y = countPathsBrute(n - 2);
        int z = countPathsBrute(n - 3);

        int count = x + y + z;

        return count;
    }

    public static int countPathsMemoized(int n, int dp[]) {
        if(n<0) return 0;
        
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int x = countPathsMemoized(n - 1, dp);
        int y = countPathsMemoized(n - 2, dp);
        int z = countPathsMemoized(n - 3, dp);

        dp[n] = x + y + z;
        return dp[n];
    }

    public static int countPathsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }

}