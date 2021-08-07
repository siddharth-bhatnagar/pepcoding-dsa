import java.util.*;

public class ClimbStairsVariableJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = scn.nextInt();
        }

        int ans = countPaths(n, arr);
        System.out.println(ans);
        scn.close();
    }

    public static int countPaths(int n, int[] arr) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i=n-1;i>=0;i--) {
            int k = i + arr[i];
            if(k > n) {
                k = n;
            }

            for(int j=k;j>i;j--) {
                dp[i] += dp[j];
            }
        }

        return dp[0];
    }
}


/*

DP - Tabulation (iterative)
O(N), O(N)
1) Storage and meaning - ith item in dp array reps the ways count from i to n
2) Direction - Right to Left (n to 0) since reaching from n to n has only 1 way i.e staying at n
3) Travel and solve - init dp array, dp[n] = 1, then traverse from n-1 to 0, find k = i + arr[i]
        if(k > n) k = n;

        loop from k to i, adding dp[i] += dp[j];

    return dp[0];

*/