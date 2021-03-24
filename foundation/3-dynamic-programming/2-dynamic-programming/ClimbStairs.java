import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(stair(n, new int[n+1]));
    }

    public static int stair(int n,int[] dp) {
        if(n==0)
            return 1;

        if(n<0)
            return 0;

        if(dp[n]!=0)
            return dp[n];

        int nm1 = stair(n-1,dp);
        int nm2 = stair(n-2,dp);
        int nm3 = stair(n-3,dp);

        int ans = nm1 + nm2 + nm3;
        dp[n] = ans;
        return ans;
    }

}