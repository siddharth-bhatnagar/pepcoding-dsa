import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = fab(n, new int[n + 1]);
        System.out.println(ans);
        scn.close();
    }

    public static int fab(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int n1 = fab(n - 1, dp);
        int n2 = fab(n - 2, dp);
        dp[n] = n1 + n2;
        return dp[n];
    }

}