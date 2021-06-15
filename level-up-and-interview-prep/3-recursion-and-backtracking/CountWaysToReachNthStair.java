import java.util.*;

public class CountWaysToReachNthStair {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        int ans = ways(n, m);
        System.out.println(ans);
        scn.close();
    }

    static int[] dp;
    public static int ways(int n, int m) {
        if(n < 0) return 0;

        if(dp[n] != 0){
            return dp[n];
        }
        int count = 0;
        for(int i=1;i<=m;i++) {
            count += ways(n-i, m);
        }
    

        dp[n] = count;
        return dp[n];
    }
}

// O(n*m) O(n)