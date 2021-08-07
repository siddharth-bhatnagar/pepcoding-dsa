import java.util.*;

public class ClimbStairsMinimumMoves {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        Integer ans = countMoves(n, arr);
        System.out.println(ans);
        scn.close();
    }

    public static Integer countMoves(int n, int[] arr) {
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                int k = i + arr[i];
                if (k > n)
                    k = n;
                int min = Integer.MAX_VALUE;
                for (int j = k; j > i; j--) {
                    if (dp[j] != null) {
                        min = Math.min(dp[j], min);
                    }
                }
                if(min != Integer.MAX_VALUE)
                    dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}