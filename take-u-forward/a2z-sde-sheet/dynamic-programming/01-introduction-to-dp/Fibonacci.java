import java.util.Arrays;

/**
 * 0 1 1 2 3 5 8 13 ...
 *  f(n) = f(n - 1) + f(n - 2)
 */
public class Fibonacci {

    // TC -> O(2^n), SC -> O(N)
    public static int f(int n) {
        if (n <= 1) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }
    
    // TC -> O(N), SC -> O(N + N)
    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) return dp[n];
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    // TC -> O(N), SC -> O(N)
    public static int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // TC -> O(N), SC -> O(1)
    public static void fibo(int n) {
        if (n <= 1) System.out.println(n);

        int a = 0;
        int b = 1;

        for(int i=2;i<=n;i++) {
            int c = a+b;
            a=b;
            b=c;
        }

        System.out.println(b);
    }

    public static void main(String args[]) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        fib(n, dp);
    }
}
